package br.com.eletrica.domain.model.api.resposta.dimensionado;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class DadosDisjuntorTest {

    @Test
    public void testaModelo() {
        var modelo = new DadosDisjuntor();

        modelo.setCorrenteNominalDisjuntorRecomendado(1);
        modelo.setNomeDisjuntorRecomendado("a");

        assertNotNull(modelo.getCorrenteNominalDisjuntorRecomendado());
        assertNotNull(modelo.getNomeDisjuntorRecomendado());
    }
}