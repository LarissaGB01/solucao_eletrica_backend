package br.com.eletrica.domain.useCases;

import br.com.eletrica.common.constantes.TIPO_UTILIZACAO;
import br.com.eletrica.common.exception.ErrosSistema;
import br.com.eletrica.common.exception.ValidacaoException;
import br.com.eletrica.domain.model.builder.BuscaSecaoMinimaBuilder;
import br.com.eletrica.domain.model.infra.DadosConducaoCabos;
import br.com.eletrica.domain.model.mappers.DadosCircuitoMapper;
import br.com.eletrica.domain.model.api.requisicao.DadosEntrada;
import br.com.eletrica.domain.model.api.resposta.DadosResposta;
import br.com.eletrica.domain.services.CalcularCorrenteService;
import br.com.eletrica.domain.services.CalcularDiametroCaboService;
import br.com.eletrica.domain.services.CalcularPotenciaService;
//import br.com.eletrica.domain.validacao.Validador;
import br.com.eletrica.infra.entidade.ConducaoCabos;
import br.com.eletrica.infra.repositorio.RepositorioNBR;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class CalcularDiametroCabosUseCase {

    public DadosResposta calcular(DadosEntrada entrada) throws ValidacaoException {

        var mapper = new DadosCircuitoMapper();
        var repositorio = new RepositorioNBR();

        // validacao
//        Validador.validarRequisicaoCabeacao(entrada);
        try {
            TIPO_UTILIZACAO.valueOf(entrada.getUtilizacaoCircuito());
        } catch (IllegalArgumentException e) {
            throw new ValidacaoException("Valor nao aceito para utilizacao do circuito. " +
                    "Utilize um desses: ",
                    ErrosSistema.FINALIDADE_CIRCUITO_INVALIDA);
        }

        var resposta = new DadosResposta();
        resposta.setCircuito(mapper.toDomain(entrada));

        // calcular potencias
        var potenciaAparente = CalcularPotenciaService.calcularAparente(
                entrada.getPotenciaAtiva(),
                entrada.getPotenciaAparente(),
                entrada.getFatorDePotencia());
        resposta.getCircuito().setPotenciaAparente(potenciaAparente);

        // calcular corrente de projeto
        var correnteProjeto = CalcularCorrenteService.calcularCorrenteProjeto(resposta.getCircuito());
        resposta.getCircuito().setCorrenteProjeto(correnteProjeto);

        // definir resistividade do cabo
        var resistividade = resposta.getCircuito().getTipoCabo().valorResistividade();

        // calcular secao do condutor
        var diametroCalculado = CalcularDiametroCaboService.calcular(resistividade, resposta.getCircuito());

        // verificar finalidade do circuito para valor minimo
        var sessaoMinima = resposta.getCircuito().getUtilizacaoCircuito().getMinimoDiametroCabo();
        if (diametroCalculado.compareTo(sessaoMinima) < 0) {
            diametroCalculado = sessaoMinima;
        }

        // buscar secao do condutor
        var dadosBuscaSecaoMinima = new BuscaSecaoMinimaBuilder()
                .setDadosCircuito(resposta.getCircuito())
                .setSecaoCalculada(diametroCalculado)
                .build();
        var dadosConducaoCalculados = new DadosConducaoCabos();
        try {
            dadosConducaoCalculados = repositorio.buscarSecaoMinimaCabo(dadosBuscaSecaoMinima);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        resposta.getCabeamento().setDiametroCabo(dadosConducaoCalculados.getSecaoNominal());
        resposta.getCabeamento().setCorrenteCabo(dadosConducaoCalculados.getCorrenteNominal());

        return resposta;
    }
}
