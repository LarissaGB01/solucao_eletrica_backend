package br.com.eletrica.infra.entidade;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ExemplosDisjuntoresTest {
    @Test
    public void testaModelo() {
        var domain = new ExemplosDisjuntores();

        domain.setCorrenteNominal(1);
        domain.setCondutoresCarregados(1);
        domain.setNomeDisjuntor("a");

        assertNotNull(domain.getCorrenteNominal());
        assertNotNull(domain.getNomeDisjuntor());
        assertNotNull(domain.getCondutoresCarregados());

        assertNotNull(ExemplosDisjuntores.getNomeTabela());
        assertNotNull(ExemplosDisjuntores.getNomeColunaCorrenteNominal());
        assertNotNull(ExemplosDisjuntores.getNomeColunaNomeDisjuntor());
        assertNotNull(ExemplosDisjuntores.getNomeColunaCondutoresCarregados());
    }
}