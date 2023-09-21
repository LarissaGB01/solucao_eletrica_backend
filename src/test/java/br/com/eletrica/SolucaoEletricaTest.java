package br.com.eletrica;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SolucaoEletricaTest {
    @Test
    public void testaInicializacao() {
        assertDoesNotThrow(() -> SolucaoEletrica.main());
    }
}
