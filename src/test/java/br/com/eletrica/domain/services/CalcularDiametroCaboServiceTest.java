package br.com.eletrica.domain.services;

import br.com.eletrica.common.constantes.FASES_VOLTAGEM;
import br.com.eletrica.common.exception.ValidacaoException;
import br.com.eletrica.fixtures.ModelFixture;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CalcularDiametroCaboServiceTest {
    @Test
    public void deveCalcularComSucesso() throws ValidacaoException {
        var calcularDiametroCaboService = new CalcularDiametroCaboService();

        var circuitoTrifasico = ModelFixture.gerarDadosCircuito();
        circuitoTrifasico.setFasesVoltagem(FASES_VOLTAGEM.TRIFASICO);
        var circuitoBifasico = ModelFixture.gerarDadosCircuito();
        circuitoBifasico.setFasesVoltagem(FASES_VOLTAGEM.BIFASICO);

        assertDoesNotThrow(() -> calcularDiametroCaboService.calcular(BigDecimal.ONE, circuitoTrifasico));
        assertDoesNotThrow(() -> calcularDiametroCaboService.calcular(BigDecimal.valueOf(100), circuitoBifasico));
    }
}