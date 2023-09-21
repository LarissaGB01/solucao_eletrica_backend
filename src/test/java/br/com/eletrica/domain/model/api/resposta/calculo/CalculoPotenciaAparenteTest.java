package br.com.eletrica.domain.model.api.resposta.calculo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CalculoPotenciaAparenteTest {

    @Test
    public void testaModelo() {
        var modelo = new CalculoPotenciaAparente();

        modelo.setIndicadorPotenciaAparenteInformada(true);
        modelo.setPotenciaAparente(BigDecimal.ONE);
        modelo.setPotenciaAtiva(BigDecimal.ONE);
        modelo.setFatorDePotencia(BigDecimal.ONE);

        assertNotNull(modelo.getIndicadorPotenciaAparenteInformada());
        assertNotNull(modelo.getPotenciaAparente());
        assertNotNull(modelo.getPotenciaAtiva());
        assertNotNull(modelo.getFatorDePotencia());
    }
}