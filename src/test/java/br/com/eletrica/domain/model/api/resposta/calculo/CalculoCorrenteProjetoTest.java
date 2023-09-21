package br.com.eletrica.domain.model.api.resposta.calculo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CalculoCorrenteProjetoTest {

    @Test
    public void testaModelo() {
        var model = new CalculoCorrenteProjeto();

        model.setIndicadorCircuitoTrifasico(true);
        model.setPotenciaAparente(new BigDecimal("5555.0"));
        model.setVoltagem(220);
        model.setCorrenteCircuito(new BigDecimal("25.0"));
        model.setQuantidadeCircuitosAgrupados(1);
        model.setFatorAgrupamento(1.0);
        model.setTemperaturaAmbiente(25);
        model.setIsolacaoCabo("THW");
        model.setFatorTemperatura(new BigDecimal("1.0"));
        model.setCorrenteProjeto(new BigDecimal("25.0"));

        assertNotNull(model.isIndicadorCircuitoTrifasico());
        assertNotNull(model.getPotenciaAparente());
        assertNotNull(model.getVoltagem());
        assertNotNull(model.getCorrenteCircuito());
        assertNotNull(model.getQuantidadeCircuitosAgrupados());
        assertNotNull(model.getFatorAgrupamento());
        assertNotNull(model.getTemperaturaAmbiente());
        assertNotNull(model.getIsolacaoCabo());
        assertNotNull(model.getFatorTemperatura());
        assertNotNull(model.getCorrenteProjeto());
    }
}