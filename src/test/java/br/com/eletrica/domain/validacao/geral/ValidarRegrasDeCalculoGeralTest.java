package br.com.eletrica.domain.validacao.geral;

import br.com.eletrica.common.exception.ValidacaoException;
import br.com.eletrica.fixtures.APIFixtures;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ValidarRegrasDeCalculoGeralTest {

    @Test
    public void deveValidarComSucesso() throws ValidacaoException {
        var validador = new ValidarRegrasDeCalculoGeral();
        var dados = APIFixtures.gerarRequisicaoGeral();

        assertDoesNotThrow(() -> validador.validar(dados));
    }

    @Test
    public void deveValidarComErro_AMBAS_POTENCIAS_PREENCHIDAS() throws ValidacaoException {
        var validador = new ValidarRegrasDeCalculoGeral();

        var dados = APIFixtures.gerarRequisicaoGeral();
        dados.setPotenciaAparente(BigDecimal.valueOf(1));
        dados.setPotenciaAtiva(BigDecimal.valueOf(1));
        dados.setFatorDePotencia(BigDecimal.valueOf(0));
        assertThrows(ValidacaoException.class, () -> validador.validar(dados));
    }

    @Test
    public void deveValidarComErro_NENHUMA_POTENCIA_PREENCHIDA() throws ValidacaoException {
        var validador = new ValidarRegrasDeCalculoGeral();

        var dados = APIFixtures.gerarRequisicaoGeral();
        dados.setPotenciaAparente(BigDecimal.valueOf(0));
        dados.setPotenciaAtiva(BigDecimal.valueOf(0));
        dados.setFatorDePotencia(BigDecimal.valueOf(0));
        assertThrows(ValidacaoException.class, () -> validador.validar(dados));
    }

    @Test
    public void deveValidarComErro_POTENCIAS_APARENTE_E_FATOR_POTENCIA_PREENCHIDOS() throws ValidacaoException {
        var validador = new ValidarRegrasDeCalculoGeral();

        var dados = APIFixtures.gerarRequisicaoGeral();
        dados.setPotenciaAparente(BigDecimal.valueOf(1));
        dados.setPotenciaAtiva(BigDecimal.valueOf(0));
        dados.setFatorDePotencia(BigDecimal.valueOf(1));
        assertThrows(ValidacaoException.class, () -> validador.validar(dados));
    }

    @Test
    public void deveValidarComErro_POTENCIA_ATIVA_PREENCHIDA_E_FATOR_POTENCIA_NAO() throws ValidacaoException {
        var validador = new ValidarRegrasDeCalculoGeral();

        var dados = APIFixtures.gerarRequisicaoGeral();
        dados.setPotenciaAparente(BigDecimal.valueOf(0));
        dados.setPotenciaAtiva(BigDecimal.valueOf(1));
        dados.setFatorDePotencia(BigDecimal.valueOf(0));
        assertThrows(ValidacaoException.class, () -> validador.validar(dados));
    }
}