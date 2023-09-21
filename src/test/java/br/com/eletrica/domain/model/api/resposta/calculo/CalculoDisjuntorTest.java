package br.com.eletrica.domain.model.api.resposta.calculo;

import br.com.eletrica.domain.model.api.resposta.DadosResposta;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CalculoDisjuntorTest {

    @Test
    public void testaModelo() {
        var modelo = new CalculoDisjuntor();

        modelo.setCabosCarregados(1);
        modelo.setFasesVoltagem("a");
        modelo.setCorrenteProjeto(BigDecimal.ONE);
        modelo.setCorrenteMaximaCabo(BigDecimal.ONE);

        assertNotNull(modelo.getCabosCarregados());
        assertNotNull(modelo.getFasesVoltagem());
        assertNotNull(modelo.getCorrenteProjeto());
        assertNotNull(modelo.getCorrenteMaximaCabo());
    }
}