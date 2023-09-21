package br.com.eletrica.domain.validacao.disjuntores;

import br.com.eletrica.common.exception.ValidacaoException;
import br.com.eletrica.fixtures.APIFixtures;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ValidarValoresNegativosDisjuntoresTest {

    @Test
    public void deveValidarComSucesso() throws ValidacaoException {
        var validador = new ValidarValoresNegativosDisjuntores();
        var dados = APIFixtures.gerarRequisicaoDisjuntores();

        assertDoesNotThrow(() -> validador.validar(dados));
    }

    @Test
    public void deveValidarComErroCampoNulo() throws ValidacaoException {
        var validador = new ValidarValoresNegativosDisjuntores();

        var dadoNuloCorrenteProjeto = APIFixtures.gerarRequisicaoDisjuntores();
        dadoNuloCorrenteProjeto.setCorrenteProjeto(null);
        assertThrows(ValidacaoException.class, () -> validador.validar(dadoNuloCorrenteProjeto));

        var dadoNuloCorrenteMaximaCabo = APIFixtures.gerarRequisicaoDisjuntores();
        dadoNuloCorrenteMaximaCabo.setCorrenteMaximaCabo(null);
        assertThrows(ValidacaoException.class, () -> validador.validar(dadoNuloCorrenteMaximaCabo));
    }

    @Test
    public void deveValidarComErroCampoZerado() throws ValidacaoException {
        var validador = new ValidarValoresNegativosDisjuntores();

        var dadoZeradoCorrenteProjeto = APIFixtures.gerarRequisicaoDisjuntores();
        dadoZeradoCorrenteProjeto.setCorrenteProjeto(BigDecimal.valueOf(0));
        assertThrows(ValidacaoException.class, () -> validador.validar(dadoZeradoCorrenteProjeto));

        var dadoZeradoCorrenteMaximaCabo = APIFixtures.gerarRequisicaoDisjuntores();
        dadoZeradoCorrenteMaximaCabo.setCorrenteMaximaCabo(BigDecimal.valueOf(0));
        assertThrows(ValidacaoException.class, () -> validador.validar(dadoZeradoCorrenteMaximaCabo));
    }

    @Test
    public void deveValidarComErroCampoNegativo() throws ValidacaoException {
        var validador = new ValidarValoresNegativosDisjuntores();

        var dadoNegativoCorrenteProjeto = APIFixtures.gerarRequisicaoDisjuntores();
        dadoNegativoCorrenteProjeto.setCorrenteProjeto(BigDecimal.valueOf(-1));
        assertThrows(ValidacaoException.class, () -> validador.validar(dadoNegativoCorrenteProjeto));

        var dadoNegativoCorrenteMaximaCabo = APIFixtures.gerarRequisicaoDisjuntores();
        dadoNegativoCorrenteMaximaCabo.setCorrenteMaximaCabo(BigDecimal.valueOf(-1));
        assertThrows(ValidacaoException.class, () -> validador.validar(dadoNegativoCorrenteMaximaCabo));
    }
}