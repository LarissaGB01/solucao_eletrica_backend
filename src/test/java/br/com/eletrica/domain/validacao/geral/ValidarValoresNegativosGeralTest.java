package br.com.eletrica.domain.validacao.geral;

import br.com.eletrica.common.exception.ValidacaoException;
import br.com.eletrica.fixtures.APIFixtures;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ValidarValoresNegativosGeralTest {

    @Test
    public void deveValidarComSucesso() throws ValidacaoException {
        var validador = new ValidarValoresNegativosGeral();
        var dados = APIFixtures.gerarRequisicaoGeral();

        assertDoesNotThrow(() -> validador.validar(dados));
    }

    @Test
    public void deveValidarComErroCampoNulo() throws ValidacaoException {
        var validador = new ValidarValoresNegativosGeral();

        var dadoNuloVoltagem = APIFixtures.gerarRequisicaoGeral();
        dadoNuloVoltagem.setVoltagem(null);
        assertThrows(ValidacaoException.class, () -> validador.validar(dadoNuloVoltagem));

        var dadoNuloTemperaturaAmbiente = APIFixtures.gerarRequisicaoGeral();
        dadoNuloTemperaturaAmbiente.setTemperaturaAmbiente(null);
        assertThrows(ValidacaoException.class, () -> validador.validar(dadoNuloTemperaturaAmbiente));

        var dadoNuloQuantidadeCircuitosAgrupados = APIFixtures.gerarRequisicaoGeral();
        dadoNuloQuantidadeCircuitosAgrupados.setQuantidadeCircuitosAgrupados(null);
        assertThrows(ValidacaoException.class, () -> validador.validar(dadoNuloQuantidadeCircuitosAgrupados));

        var dadoNuloComprimentoFio = APIFixtures.gerarRequisicaoGeral();
        dadoNuloComprimentoFio.setComprimentoFio(null);
        assertThrows(ValidacaoException.class, () -> validador.validar(dadoNuloComprimentoFio));
    }

    @Test
    public void deveValidarComErroCampoZerado() throws ValidacaoException {
        var validador = new ValidarValoresNegativosGeral();

        var dadoZeradoVoltagem = APIFixtures.gerarRequisicaoGeral();
        dadoZeradoVoltagem.setVoltagem(0);
        assertThrows(ValidacaoException.class, () -> validador.validar(dadoZeradoVoltagem));

        var dadoZeradoTemperaturaAmbiente = APIFixtures.gerarRequisicaoGeral();
        dadoZeradoTemperaturaAmbiente.setTemperaturaAmbiente(0);
        assertThrows(ValidacaoException.class, () -> validador.validar(dadoZeradoTemperaturaAmbiente));

        var dadoZeradoQuantidadeCircuitosAgrupados = APIFixtures.gerarRequisicaoGeral();
        dadoZeradoQuantidadeCircuitosAgrupados.setQuantidadeCircuitosAgrupados(0);
        assertThrows(ValidacaoException.class, () -> validador.validar(dadoZeradoQuantidadeCircuitosAgrupados));

        var dadoZeradoComprimentoFio = APIFixtures.gerarRequisicaoGeral();
        dadoZeradoComprimentoFio.setComprimentoFio(0);
        assertThrows(ValidacaoException.class, () -> validador.validar(dadoZeradoComprimentoFio));
    }

    @Test
    public void deveValidarComErroCampoNegativo() throws ValidacaoException {
        var validador = new ValidarValoresNegativosGeral();

        var dadoNegativoVoltagem = APIFixtures.gerarRequisicaoGeral();
        dadoNegativoVoltagem.setVoltagem(-1);
        assertThrows(ValidacaoException.class, () -> validador.validar(dadoNegativoVoltagem));

        var dadoNegativoTemperaturaAmbiente = APIFixtures.gerarRequisicaoGeral();
        dadoNegativoTemperaturaAmbiente.setTemperaturaAmbiente(-1);
        assertThrows(ValidacaoException.class, () -> validador.validar(dadoNegativoTemperaturaAmbiente));

        var dadoNegativoQuantidadeCircuitosAgrupados = APIFixtures.gerarRequisicaoGeral();
        dadoNegativoQuantidadeCircuitosAgrupados.setQuantidadeCircuitosAgrupados(-1);
        assertThrows(ValidacaoException.class, () -> validador.validar(dadoNegativoQuantidadeCircuitosAgrupados));

        var dadoNegativoComprimentoFio = APIFixtures.gerarRequisicaoGeral();
        dadoNegativoComprimentoFio.setComprimentoFio(-1);
        assertThrows(ValidacaoException.class, () -> validador.validar(dadoNegativoComprimentoFio));

        var dadoNegativoPotenciaAtiva = APIFixtures.gerarRequisicaoGeral();
        dadoNegativoPotenciaAtiva.setPotenciaAtiva(BigDecimal.valueOf(-1));
        assertThrows(ValidacaoException.class, () -> validador.validar(dadoNegativoPotenciaAtiva));

        var dadoNegativoPotenciaAparente = APIFixtures.gerarRequisicaoGeral();
        dadoNegativoPotenciaAparente.setPotenciaAparente(BigDecimal.valueOf(-1));
        assertThrows(ValidacaoException.class, () -> validador.validar(dadoNegativoPotenciaAparente));

        var dadoNegativoFatorDePotencia = APIFixtures.gerarRequisicaoGeral();
        dadoNegativoFatorDePotencia.setFatorDePotencia(BigDecimal.valueOf(-1));
        assertThrows(ValidacaoException.class, () -> validador.validar(dadoNegativoFatorDePotencia));

        var dadoMaiorQueUmFatorDePotencia = APIFixtures.gerarRequisicaoGeral();
        dadoMaiorQueUmFatorDePotencia.setFatorDePotencia(BigDecimal.valueOf(2));
        assertThrows(ValidacaoException.class, () -> validador.validar(dadoMaiorQueUmFatorDePotencia));
    }
}