package br.com.eletrica.domain.services;

import br.com.eletrica.common.constantes.FASES_VOLTAGEM;
import br.com.eletrica.common.exception.ValidacaoException;
import br.com.eletrica.fixtures.ModelFixture;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CalcularPotenciaServiceTest {
    @Test
    public void deveCalcularComSucesso() throws ValidacaoException {
        var calcularDiametroCaboService = new CalcularPotenciaService();
        assertDoesNotThrow(() -> calcularDiametroCaboService.calcularAparente(BigDecimal.ONE, BigDecimal.ZERO, BigDecimal.ONE));
        assertDoesNotThrow(() -> calcularDiametroCaboService.calcularAparente(BigDecimal.ZERO, BigDecimal.ONE, BigDecimal.ZERO));
    }
}