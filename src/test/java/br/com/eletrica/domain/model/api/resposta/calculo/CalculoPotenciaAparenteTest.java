package br.com.eletrica.domain.model.api.resposta.calculo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CalculoEletrodutoTest {

    @Test
    public void testaModelo() {
        var modelo = new CalculoEletroduto();

        modelo.setQuantidadeCondutores(1);
        modelo.setDiametroCabo(1.0);
        modelo.setDiametroMinimoCalculado(BigDecimal.ONE);
        modelo.setSecaoNominalCabo(BigDecimal.ONE);

        assertNotNull(modelo.getQuantidadeCondutores());
        assertNotNull(modelo.getDiametroCabo());
        assertNotNull(modelo.getDiametroMinimoCalculado());
        assertNotNull(modelo.getSecaoNominalCabo());
    }
}