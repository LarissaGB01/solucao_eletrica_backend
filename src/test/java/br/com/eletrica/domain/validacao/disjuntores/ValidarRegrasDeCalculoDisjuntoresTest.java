package br.com.eletrica.domain.validacao.geral;

import br.com.eletrica.common.exception.ValidacaoException;
import br.com.eletrica.fixtures.APIFixtures;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ValidarRegrasDeCalculoDisjuntoresTest {

    @Test
    public void deveValidarComSucesso() throws ValidacaoException {
        var validador = new ValidarConstantesGeral();
        var dados = APIFixtures.gerarRequisicaoGeral();

        assertDoesNotThrow(() -> validador.validar(dados));
    }

    @Test
    public void deveValidarComErroCampoNulo() throws ValidacaoException {
        var validador = new ValidarConstantesGeral();

        var dadoNuloUtilizacaoCircuito = APIFixtures.gerarRequisicaoGeral();
        dadoNuloUtilizacaoCircuito.setUtilizacaoCircuito(null);
        assertThrows(ValidacaoException.class, () -> validador.validar(dadoNuloUtilizacaoCircuito));

        var dadoNuloFasesVoltagem = APIFixtures.gerarRequisicaoGeral();
        dadoNuloFasesVoltagem.setFasesVoltagem(null);
        assertThrows(ValidacaoException.class, () -> validador.validar(dadoNuloFasesVoltagem));

        var dadoNuloMetodoInstalacao = APIFixtures.gerarRequisicaoGeral();
        dadoNuloMetodoInstalacao.setMetodoInstalacao(null);
        assertThrows(ValidacaoException.class, () -> validador.validar(dadoNuloMetodoInstalacao));

        var dadoNuloTipoCabo = APIFixtures.gerarRequisicaoGeral();
        dadoNuloTipoCabo.setTipoCabo(null);
        assertThrows(ValidacaoException.class, () -> validador.validar(dadoNuloTipoCabo));

        var dadoNuloTipoCircuito = APIFixtures.gerarRequisicaoGeral();
        dadoNuloTipoCircuito.setTipoCircuito(null);
        assertThrows(ValidacaoException.class, () -> validador.validar(dadoNuloTipoCircuito));
    }

    @Test
    public void deveValidarComErroCampoInvalido() throws ValidacaoException {
        var validador = new ValidarConstantesGeral();

        var dadoInvalidoUtilizacaoCircuito = APIFixtures.gerarRequisicaoGeral();
        dadoInvalidoUtilizacaoCircuito.setUtilizacaoCircuito("a");
        assertThrows(ValidacaoException.class, () -> validador.validar(dadoInvalidoUtilizacaoCircuito));

        var dadoInvalidoFasesVoltagem = APIFixtures.gerarRequisicaoGeral();
        dadoInvalidoFasesVoltagem.setFasesVoltagem("a");
        assertThrows(ValidacaoException.class, () -> validador.validar(dadoInvalidoFasesVoltagem));

        var dadoInvalidoMetodoInstalacao = APIFixtures.gerarRequisicaoGeral();
        dadoInvalidoMetodoInstalacao.setMetodoInstalacao("a");
        assertThrows(ValidacaoException.class, () -> validador.validar(dadoInvalidoMetodoInstalacao));

        var dadoInvalidoTipoCabo = APIFixtures.gerarRequisicaoGeral();
        dadoInvalidoTipoCabo.setTipoCabo("a");
        assertThrows(ValidacaoException.class, () -> validador.validar(dadoInvalidoTipoCabo));

        var dadoInvalidoTipoCircuito = APIFixtures.gerarRequisicaoGeral();
        dadoInvalidoTipoCircuito.setTipoCircuito("a");
        assertThrows(ValidacaoException.class, () -> validador.validar(dadoInvalidoTipoCircuito));
    }
}