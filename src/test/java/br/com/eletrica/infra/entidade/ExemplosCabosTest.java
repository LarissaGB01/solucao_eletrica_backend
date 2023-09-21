package br.com.eletrica.infra.entidade;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ExemplosCabosTest {
    @Test
    public void testaModelo() {
        var domain = new ExemplosCabos();

        domain.setCabosCarregados(1);
        domain.setDiametroNominalCondutor(BigDecimal.ONE);
        domain.setDiametroNominalExterno(BigDecimal.ONE);
        domain.setSecaoNominal(BigDecimal.ONE);

        assertNotNull(domain.getCabosCarregados());
        assertNotNull(domain.getDiametroNominalCondutor());
        assertNotNull(domain.getDiametroNominalExterno());
        assertNotNull(domain.getSecaoNominal());

        assertNotNull(ExemplosCabos.getNomeTabela());
        assertNotNull(ExemplosCabos.getNomeColunaCabosCarregados());
        assertNotNull(ExemplosCabos.getNomeColunaDiametroNominalCondutor());
        assertNotNull(ExemplosCabos.getNomeColunaDiametroNominalExterno());
        assertNotNull(ExemplosCabos.getNomeColunaSecaoNominal());
    }
}