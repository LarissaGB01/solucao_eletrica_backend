package br.com.eletrica.domain.validacao.disjuntores;

import br.com.eletrica.common.exception.ValidacaoException;
import br.com.eletrica.fixtures.APIFixtures;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ValidarConstantesDisjuntoresTest {

    @Test
    public void deveValidarComSucesso() throws ValidacaoException {
        var validador = new ValidarConstantesDisjuntores();
        var dados = APIFixtures.gerarRequisicaoDisjuntores();

        assertDoesNotThrow(() -> validador.validar(dados));
    }

    @Test
    public void deveValidarComErroCampoNulo() throws ValidacaoException {
        var validador = new ValidarConstantesDisjuntores();

        var dadoNuloFasesVoltagem = APIFixtures.gerarRequisicaoDisjuntores();
        dadoNuloFasesVoltagem.setFasesVoltagem(null);
        assertThrows(ValidacaoException.class, () -> validador.validar(dadoNuloFasesVoltagem));
    }

    @Test
    public void deveValidarComErroCampoInvalido() throws ValidacaoException {
        var validador = new ValidarConstantesDisjuntores();

        var dadoInvalidoFasesVoltagem = APIFixtures.gerarRequisicaoDisjuntores();
        dadoInvalidoFasesVoltagem.setFasesVoltagem("a");
        assertThrows(ValidacaoException.class, () -> validador.validar(dadoInvalidoFasesVoltagem));
    }
}