package br.com.eletrica.domain.useCases;

import br.com.eletrica.common.constantes.FASES_VOLTAGEM;
import br.com.eletrica.common.exception.ValidacaoException;
import br.com.eletrica.domain.model.api.requisicao.DadosEntrada;
import br.com.eletrica.domain.model.api.requisicao.DadosEntradaDisjuntores;
import br.com.eletrica.domain.model.api.resposta.DadosResposta;
import br.com.eletrica.domain.model.infra.DadosBuscaExemploDisjuntor;
import br.com.eletrica.domain.validacao.ValidadorDisjuntores;
import br.com.eletrica.infra.repositorio.RepositorioNBR;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CalcularDisjuntoresUseCase {

    private final RepositorioNBR repositorioNBR;
    private final CalcularDiametroCabosUseCase dimensionarCondutoresUseCase;

    public DadosResposta calcularSemCondutores(DadosEntradaDisjuntores entrada) throws ValidacaoException {

        var resposta = new DadosResposta();

        // Validação
        ValidadorDisjuntores.validarRequisicao(entrada);

        var fasesVoltagem = FASES_VOLTAGEM.valueOf(entrada.getFasesVoltagem());
        var correnteProjeto = entrada.getCorrenteProjeto();
        var correnteMaximaCabo = entrada.getCorrenteMaximaCabo();

        resposta.getDadosUtilizadosParaCalculo().getCalculoDisjuntor().setCorrenteProjeto(correnteProjeto);
        resposta.getDadosUtilizadosParaCalculo().getCalculoDisjuntor().setCorrenteMaximaCabo(correnteMaximaCabo);
        resposta.getDadosUtilizadosParaCalculo().getCalculoDisjuntor().setFasesVoltagem(fasesVoltagem.get());
        resposta.getDadosUtilizadosParaCalculo().getCalculoDisjuntor().setCabosCarregados(fasesVoltagem.getCabosCarregados());

        // Buscar disjuntor recomendado
        var dadosParaBuscaDisjuntor = new DadosBuscaExemploDisjuntor(fasesVoltagem, correnteProjeto, correnteMaximaCabo);
        var disjuntorRecomendado = repositorioNBR.buscarExemploDisjuntor(dadosParaBuscaDisjuntor);

        var nomeDisjuntor = "";
        var correnteNominal = 0;

        if (disjuntorRecomendado != null) {
            nomeDisjuntor = disjuntorRecomendado.getNomeDisjuntor();
            correnteNominal = disjuntorRecomendado.getCorrenteNominal();
        }

        resposta.getDadosDimensionados().getDisjuntor().setNomeDisjuntorRecomendado(nomeDisjuntor);
        resposta.getDadosDimensionados().getDisjuntor().setCorrenteNominalDisjuntorRecomendado(correnteNominal);

        return resposta;
    }

    public DadosResposta calcularComCondutores(DadosEntrada entrada) throws ValidacaoException {

        // calcular condutores
        var dadosCondutores = dimensionarCondutoresUseCase.calcular(entrada);

        // dimensionar disjuntor
        var requisicaoDisjuntores = new DadosEntradaDisjuntores();
        requisicaoDisjuntores.setCorrenteMaximaCabo(dadosCondutores.getDadosDimensionados().getCabeamento().getCorrenteMaximaCondutor());
        requisicaoDisjuntores.setCorrenteProjeto(dadosCondutores.getDadosUtilizadosParaCalculo().getCalculoSecaoCondutor().getCalculoCorrenteProjeto().getCorrenteProjeto());
        requisicaoDisjuntores.setFasesVoltagem(entrada.getFasesVoltagem());

        return calcularSemCondutores(requisicaoDisjuntores);
    }
}
