package br.com.eletrica.domain.useCases;

import br.com.eletrica.common.exception.ErrosSistema;
import br.com.eletrica.common.exception.ValidacaoException;
import br.com.eletrica.domain.model.api.requisicao.DadosEntrada;
import br.com.eletrica.domain.model.api.resposta.DadosResposta;
import br.com.eletrica.domain.model.infra.DadosBuscaExemploCondutor;
import br.com.eletrica.domain.model.infra.DadosConducaoCabos;
import br.com.eletrica.domain.model.infra.DadosExemploCondutor;
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
        var circuito = mapper.toDomain(entrada);

        // Calcular potências
        var dadosCalculoPotenciaAparente = CalcularPotenciaService.calcularAparente(
                entrada.getPotenciaAtiva(),
                entrada.getPotenciaAparente(),
                entrada.getFatorDePotencia());

        resposta.getCalculoSecaoCondutor().setCalculoPotenciaAparente(dadosCalculoPotenciaAparente);
        circuito.setPotenciaAparente(dadosCalculoPotenciaAparente.getPotenciaAparente());

        // Calcular corrente de projeto
        var dadosCalculoCorrenteProjeto = calcularCorrenteService.calcularCorrenteProjeto(circuito);

        resposta.getCalculoSecaoCondutor().setCalculoCorrenteProjeto(dadosCalculoCorrenteProjeto);
        circuito.setCorrenteProjeto(dadosCalculoCorrenteProjeto.getCorrenteProjeto());

        // Definir resistividade do cabo
        var resistividade = circuito.getTipoCabo().valorResistividade();

        // Calcular seção do condutor
        var calculoDiametro = CalcularDiametroCaboService.calcular(resistividade, circuito);

        resposta.getCalculoSecaoCondutor().setCalculoDiametroMinimoCabo(calculoDiametro);

        // Buscar seção do condutor
        var diametroCabo = calculoDiametro.getIndicadorMinimoDiametroUtilizado() ?
                calculoDiametro.getMinimoDiametroCabo() :
                calculoDiametro.getDiametroCalculado();
        var dadosParaBuscaSecaoMinima = new DadosConducaoCabos(circuito, diametroCabo);
        var dadosConducaoCalculados = repositorioNBR.buscarSecaoMinimaCabo(dadosParaBuscaSecaoMinima);

        if (dadosConducaoCalculados == null) {
            throw new ValidacaoException("Tente informar outros dados para o sistema.",
                    ErrosSistema.REGISTRO_DIAMETRO_NAO_ENCONTRADO);
        }

        resposta.getCabeamento().setSecaoNominalCondutor(dadosConducaoCalculados.getSecaoNominal());
        resposta.getCabeamento().setCorrenteMaximaCondutor(dadosConducaoCalculados.getCorrenteNominal());

        // Buscar condutor recomendado
        var dadosParaBuscaCondutor = new DadosBuscaExemploCondutor(circuito, dadosConducaoCalculados.getSecaoNominal());
        var condutorRecomendado = repositorioNBR.buscarExemploCabeamento(dadosParaBuscaCondutor);

        if (condutorRecomendado != null) {
            resposta.getCabeamento().setDiametroNominalCaboRecomendado(condutorRecomendado.getDiametroNominalCondutor());
            resposta.getCabeamento().setDiametroExternoCaboRecomendado(condutorRecomendado.getDiametroNominalExterno());
        }

        return resposta;
    }
}
