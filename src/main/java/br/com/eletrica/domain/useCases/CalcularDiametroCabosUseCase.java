package br.com.eletrica.domain.useCases;

import br.com.eletrica.common.exception.ErrosSistema;
import br.com.eletrica.common.exception.ValidacaoException;
import br.com.eletrica.domain.model.api.requisicao.DadosEntrada;
import br.com.eletrica.domain.model.api.resposta.DadosResposta;
import br.com.eletrica.domain.model.infra.DadosConducaoCabos;
import br.com.eletrica.domain.model.mappers.DadosCircuitoMapper;
import br.com.eletrica.domain.services.CalcularCorrenteService;
import br.com.eletrica.domain.services.CalcularDiametroCaboService;
import br.com.eletrica.domain.services.CalcularPotenciaService;
import br.com.eletrica.domain.validacao.Validador;
import br.com.eletrica.infra.repositorio.RepositorioNBR;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CalcularDiametroCabosUseCase {

    private final DadosCircuitoMapper mapper;
    private final RepositorioNBR repositorioNBR;
    private final CalcularCorrenteService calcularCorrenteService;

    public DadosResposta calcular(DadosEntrada entrada) throws ValidacaoException {

        // Validação
        Validador.validarRequisicaoCabeacao(entrada);

        var resposta = new DadosResposta();
        resposta.setCircuito(mapper.toDomain(entrada));

        // Calcular potências
        var potenciaAparente = CalcularPotenciaService.calcularAparente(
                entrada.getPotenciaAtiva(),
                entrada.getPotenciaAparente(),
                entrada.getFatorDePotencia());
        resposta.getCircuito().setPotenciaAparente(potenciaAparente);

        // Calcular corrente de projeto
        var correnteProjeto = calcularCorrenteService.calcularCorrenteProjeto(resposta.getCircuito());
        resposta.getCircuito().setCorrenteProjeto(correnteProjeto);

        // Definir resistividade do cabo
        var resistividade = resposta.getCircuito().getTipoCabo().valorResistividade();

        // Calcular seção do condutor
        var diametroCalculado = CalcularDiametroCaboService.calcular(resistividade, resposta.getCircuito());

        // Verificar finalidade do circuito para valor mínimo
        var secaoMinima = resposta.getCircuito().getUtilizacaoCircuito().getMinimoDiametroCabo();
        if (diametroCalculado.compareTo(secaoMinima) < 0) {
            diametroCalculado = secaoMinima;
        }

        // Buscar seção do condutor
        var dadosParaBuscaSecaoMinima = new DadosConducaoCabos(resposta.getCircuito(), diametroCalculado);
        var dadosConducaoCalculados = repositorioNBR.buscarSecaoMinimaCabo(dadosParaBuscaSecaoMinima);

        if (dadosConducaoCalculados == null) {
            throw new ValidacaoException("Tente informar outros dados para o sistema.",
                    ErrosSistema.REGISTRO_DIAMETRO_NAO_ENCONTRADO);
        }

        resposta.getCabeamento().setDiametroCabo(dadosConducaoCalculados.getSecaoNominal());
        resposta.getCabeamento().setCorrenteCabo(dadosConducaoCalculados.getCorrenteNominal());

        return resposta;
    }
}
