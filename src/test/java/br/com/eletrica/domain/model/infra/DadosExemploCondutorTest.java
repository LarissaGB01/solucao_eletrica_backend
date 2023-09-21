package br.com.eletrica.domain.model.infra;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class DadosExemploCondutorTest {

    @Test
    public void testaModelo() {
        var model = new DadosExemploCondutor();

        model.setSecaoNominal(BigDecimal.ONE);
        model.setDiametroNominalCondutor(BigDecimal.ONE);
        model.setDiametroNominalExterno(BigDecimal.ONE);

        assertNotNull(model.getSecaoNominal());
        assertNotNull(model.getDiametroNominalCondutor());
        assertNotNull(model.getDiametroNominalExterno());
    }
}