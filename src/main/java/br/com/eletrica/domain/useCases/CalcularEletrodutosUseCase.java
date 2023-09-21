package br.com.eletrica.domain.useCases;

import br.com.eletrica.common.exception.ValidacaoException;
import br.com.eletrica.domain.model.api.requisicao.DadosEntrada;
import br.com.eletrica.domain.model.api.requisicao.DadosEntradaEletrodutos;
import br.com.eletrica.domain.model.api.resposta.DadosResposta;
import br.com.eletrica.domain.validacao.ValidadorEletrodutos;
import br.com.eletrica.infra.repositorio.RepositorioNBR;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
@RequiredArgsConstructor
public class CalcularEletrodutosUseCase {

    private final RepositorioNBR repositorioNBR;
    private final CalcularDiametroCabosUseCase dimensionarCondutoresUseCase;

    public DadosResposta calcularSemCondutores(DadosEntradaEletrodutos entrada) throws ValidacaoException {

        var resposta = new DadosResposta();
        resposta.getDadosUtilizadosParaCalculo().getCalculoEletroduto().setSecaoNominalCabo(entrada.getSecaoNominalCabo());
        resposta.getDadosUtilizadosParaCalculo().getCalculoEletroduto().setQuantidadeCondutores(entrada.getQuantidadeCondutores());

        // Validação
        ValidadorEletrodutos.validarRequisicao(entrada);

        var diametroCondutor = Math.sqrt(entrada.getSecaoNominalCabo()
                .multiply(BigDecimal.valueOf(4))
                .divide(BigDecimal.valueOf(Math.PI), RoundingMode.HALF_EVEN).doubleValue());
        resposta.getDadosUtilizadosParaCalculo().getCalculoEletroduto().setDiametroCabo(diametroCondutor);

        var diametroMinimo = BigDecimal.valueOf(diametroCondutor * entrada.getQuantidadeCondutores() * 100/40);
        resposta.getDadosUtilizadosParaCalculo().getCalculoEletroduto().setDiametroMinimoCalculado(diametroMinimo);

        // Buscar disjuntor recomendado
        var eletrodutoRecomendado = repositorioNBR.buscarExemploEletroduto(diametroMinimo);

        var diametroNominalPolegadas = "";
        var diametroNominalMilimetros = 0;
        var diametroExterno = BigDecimal.ZERO;
        var diametroInterno = BigDecimal.ZERO;

        if (eletrodutoRecomendado != null) {
            diametroNominalPolegadas = eletrodutoRecomendado.getDiametroNominalPolegadas();
            diametroNominalMilimetros = eletrodutoRecomendado.getDiametroNominalMilimetros();
            diametroExterno = eletrodutoRecomendado.getDiametroExterno();
            diametroInterno = eletrodutoRecomendado.getDiametroInterno();
        }

        resposta.getDadosDimensionados().getEletroduto().setDiametroInternoEletrodutoSugerido(diametroInterno);
        resposta.getDadosDimensionados().getEletroduto().setDiametroExternoEletrodutoSugerido(diametroExterno);
        resposta.getDadosDimensionados().getEletroduto().setDiametroNominalEletrodutoSugeridoMilimetros(diametroNominalMilimetros);
        resposta.getDadosDimensionados().getEletroduto().setDiametroNominalEletrodutoSugeridoPolegadas(diametroNominalPolegadas);

        return resposta;
    }

    public DadosResposta calcularComCondutores(DadosEntrada entrada) throws ValidacaoException {

        // calcular condutores
        var dadosCondutores = dimensionarCondutoresUseCase.calcular(entrada);

        // dimensionar disjuntor
        var requisicaoEletrodutos = new DadosEntradaEletrodutos();
        requisicaoEletrodutos.setSecaoNominalCabo(dadosCondutores.getDadosDimensionados().getCabeamento().getSecaoNominalCondutor());
        requisicaoEletrodutos.setQuantidadeCondutores(dadosCondutores.getDadosUtilizadosParaCalculo().getCalculoSecaoCondutor().getCalculoCorrenteProjeto().getQuantidadeCircuitosAgrupados());

        return calcularSemCondutores(requisicaoEletrodutos);
    }
}
