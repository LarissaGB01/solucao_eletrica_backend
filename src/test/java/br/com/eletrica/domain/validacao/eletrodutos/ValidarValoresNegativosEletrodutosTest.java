package br.com.eletrica.domain.validacao.eletrodutos;

import br.com.eletrica.common.exception.ValidacaoException;
import br.com.eletrica.fixtures.APIFixtures;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ValidarValoresNegativosEletrodutosTest {

    @Test
    public void deveValidarComSucesso() throws ValidacaoException {
        var validador = new ValidarValoresNegativosEletrodutos();
        var dados = APIFixtures.gerarRequisicaoEletrodutos();

        assertDoesNotThrow(() -> validador.validar(dados));
    }

    @Test
    public void deveValidarComErroCampoNulo() throws ValidacaoException {
        var validador = new ValidarValoresNegativosEletrodutos();

        var dadoNuloCorrenteProjeto = APIFixtures.gerarRequisicaoEletrodutos();
        dadoNuloCorrenteProjeto.setQuantidadeCondutores(null);
        assertThrows(ValidacaoException.class, () -> validador.validar(dadoNuloCorrenteProjeto));

        var dadoNuloCorrenteMaximaCabo = APIFixtures.gerarRequisicaoEletrodutos();
        dadoNuloCorrenteMaximaCabo.setSecaoNominalCabo(null);
        assertThrows(ValidacaoException.class, () -> validador.validar(dadoNuloCorrenteMaximaCabo));
    }

    @Test
    public void deveValidarComErroCampoZerado() throws ValidacaoException {
        var validador = new ValidarValoresNegativosEletrodutos();

        var dadoZeradoCorrenteProjeto = APIFixtures.gerarRequisicaoEletrodutos();
        dadoZeradoCorrenteProjeto.setQuantidadeCondutores(0);
        assertThrows(ValidacaoException.class, () -> validador.validar(dadoZeradoCorrenteProjeto));

        var dadoZeradoCorrenteMaximaCabo = APIFixtures.gerarRequisicaoEletrodutos();
        dadoZeradoCorrenteMaximaCabo.setSecaoNominalCabo(BigDecimal.valueOf(0));
        assertThrows(ValidacaoException.class, () -> validador.validar(dadoZeradoCorrenteMaximaCabo));
    }

    @Test
    public void deveValidarComErroCampoNegativo() throws ValidacaoException {
        var validador = new ValidarValoresNegativosEletrodutos();

        var dadoNegativoCorrenteProjeto = APIFixtures.gerarRequisicaoEletrodutos();
        dadoNegativoCorrenteProjeto.setQuantidadeCondutores(-1);
        assertThrows(ValidacaoException.class, () -> validador.validar(dadoNegativoCorrenteProjeto));

        var dadoNegativoCorrenteMaximaCabo = APIFixtures.gerarRequisicaoEletrodutos();
        dadoNegativoCorrenteMaximaCabo.setSecaoNominalCabo(BigDecimal.valueOf(-1));
        assertThrows(ValidacaoException.class, () -> validador.validar(dadoNegativoCorrenteMaximaCabo));
    }
}