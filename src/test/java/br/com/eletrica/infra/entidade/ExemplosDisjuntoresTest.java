package br.com.eletrica.infra.entidade;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class FatorTemperaturaTest {
    @Test
    public void testaModelo() {
        var modelo = new FatorTemperatura();

        modelo.setTemperatura(1);
        modelo.setFatorCorrecao(BigDecimal.ONE);
        modelo.setIsolacao("a");

        assertNotNull(modelo.getTemperatura());
        assertNotNull(modelo.getFatorCorrecao());
        assertNotNull(modelo.getIsolacao());

        assertNotNull(FatorTemperatura.getNomeTabela());
        assertNotNull(FatorTemperatura.getNomeColunaTemperatura());
        assertNotNull(FatorTemperatura.getNomeColunaFatorCorrecao());
        assertNotNull(FatorTemperatura.getNomeColunaIsolacao());
    }
}