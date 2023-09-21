package br.com.eletrica.domain.validacao.disjuntores;

import br.com.eletrica.common.exception.ValidacaoException;
import br.com.eletrica.domain.validacao.geral.ValidarRegrasDeCalculoGeral;
import br.com.eletrica.fixtures.APIFixtures;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ValidarRegrasDeCalculoDisjuntoresTest {

    @Test
    public void deveValidarComSucesso() throws ValidacaoException {
        var validador = new ValidarRegrasDeCalculoDisjuntores();
        var dados = APIFixtures.gerarRequisicaoDisjuntores();

        assertDoesNotThrow(() -> validador.validar(dados));
    }

    @Test
    public void deveValidarComErro_CORRENTES_INFORMADAS_INVALIDAS() throws ValidacaoException {
        var validador = new ValidarRegrasDeCalculoDisjuntores();

        var dadosAcima = APIFixtures.gerarRequisicaoDisjuntores();
        dadosAcima.setCorrenteMaximaCabo(BigDecimal.valueOf(1));
        dadosAcima.setCorrenteProjeto(BigDecimal.valueOf(1));
        assertThrows(ValidacaoException.class, () -> validador.validar(dadosAcima));

        var dadosIguais = APIFixtures.gerarRequisicaoDisjuntores();
        dadosIguais.setCorrenteMaximaCabo(BigDecimal.valueOf(1));
        dadosIguais.setCorrenteProjeto(BigDecimal.valueOf(10));
        assertThrows(ValidacaoException.class, () -> validador.validar(dadosIguais));
    }
}