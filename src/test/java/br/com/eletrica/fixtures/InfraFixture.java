package br.com.eletrica.fixtures;

import br.com.eletrica.infra.entidade.ConducaoCabos;
import br.com.eletrica.infra.entidade.ExemplosCabos;
import br.com.eletrica.infra.entidade.ExemplosDisjuntores;
import br.com.eletrica.infra.entidade.ExemplosEletrodutos;

import java.math.BigDecimal;

public class InfraFixture {
    public static ConducaoCabos gerarConducaoCabos() {
        var domain = new ConducaoCabos();

        domain.setMaterial("a");
        domain.setSecaoNominal(BigDecimal.ONE);
        domain.setInstalacao("a");
        domain.setCondutoresCarregados(1);
        domain.setCorrenteNominal(BigDecimal.ONE);
        domain.setIsolamento("a");

        return domain;
    }

    public static ExemplosEletrodutos gerarExemplosEletrodutos() {
        var domain = new ExemplosEletrodutos();

        domain.setDiametroExterno(BigDecimal.ONE);
        domain.setDiametroInterno(BigDecimal.ONE);
        domain.setDiametroNominalMilimetros(1);
        domain.setDiametroNominalPolegadas("A");

        return domain;
    }

    public static ExemplosCabos gerarExemplosCabos() {
        var domain = new ExemplosCabos();

        domain.setDiametroNominalExterno(BigDecimal.ONE);
        domain.setDiametroNominalCondutor(BigDecimal.ONE);

        return domain;
    }

    public static ExemplosDisjuntores gerarExemplosDisjuntores() {
        var domain = new ExemplosDisjuntores();

        domain.setCorrenteNominal(1);
        domain.setNomeDisjuntor("a");

        return domain;
    }
}
