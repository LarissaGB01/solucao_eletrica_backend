package br.com.eletrica.domain.model.infra;

import br.com.eletrica.fixtures.ModelFixture;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class DadosBuscaFatorTemperaturaTest {

    @Test
    public void testaModelo() {
        var model = new DadosBuscaFatorTemperatura(ModelFixture.gerarDadosCircuito());

        model.setTemperatura(BigDecimal.ONE);
        model.setIsolacao("a");

        assertNotNull(model.getTemperatura());
        assertNotNull(model.getIsolacao());
    }
}