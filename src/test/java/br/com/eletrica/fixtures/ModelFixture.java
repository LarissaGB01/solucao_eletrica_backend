package br.com.eletrica.fixtures;

import br.com.eletrica.common.constantes.*;
import br.com.eletrica.domain.model.DadosCircuito;
import br.com.eletrica.domain.model.api.requisicao.DadosEntrada;
import br.com.eletrica.domain.model.api.resposta.calculo.CalculoDiametroMinimoCabo;
import br.com.eletrica.domain.model.api.resposta.calculo.CalculoPotenciaAparente;
import br.com.eletrica.domain.model.infra.*;
import br.com.eletrica.infra.entidade.ConducaoCabos;

import java.math.BigDecimal;

public class ModelFixture {
    public static DadosConducaoCabos gerarDadosConducaoCabos() {
        var model = new DadosConducaoCabos();
        model.setMaterial("a");
        model.setSecaoNominal(BigDecimal.ONE);
        model.setInstalacao("a");
        model.setCondutoresCarregados(1);
        model.setCorrenteNominal(BigDecimal.ONE);
        model.setIsolamento("a");
        return model;
    }

    public static DadosExemploCondutor gerarExemploCabeamento() {
        var model = new DadosExemploCondutor();
        model.setSecaoNominal(BigDecimal.ONE);
        model.setDiametroNominalCondutor(BigDecimal.ONE);
        model.setDiametroNominalExterno(BigDecimal.ONE);
        return model;
    }

    public static CalculoPotenciaAparente gerarDadosPotencia() {
        var model = new CalculoPotenciaAparente();
        model.setPotenciaAparente(BigDecimal.ONE);
        model.setFatorDePotencia(BigDecimal.ONE);
        model.setPotenciaAtiva(BigDecimal.ONE);
        model.setIndicadorPotenciaAparenteInformada(true);
        return model;
    }

    public static DadosCircuito gerarDadosCircuito() {
        var requisicao = new DadosCircuito();

        requisicao.setUtilizacaoCircuito(TIPO_UTILIZACAO.TOMADA);
        requisicao.setTipoCircuito(TIPO_CIRCUITO.DISTRIBUICAO);
        requisicao.setFasesVoltagem(FASES_VOLTAGEM.TRIFASICO);
        requisicao.setVoltagem(380);
        requisicao.setMetodoInstalacao(METODO_INSTALACAO.A1);
        requisicao.setTipoCabo(TIPO_CABO.ALUMINIO);
        requisicao.setPotenciaAtiva(new BigDecimal("12000"));
        requisicao.setPotenciaAparente(new BigDecimal("0"));
        requisicao.setFatorDePotencia(new BigDecimal("0.8"));
        requisicao.setTemperaturaAmbiente(50);
        requisicao.setQuantidadeCircuitosAgrupados(2);
        requisicao.setComprimentoFio(60);

        return requisicao;
    }

    public static DadosExemploDisjuntor gerarExemploDisjuntor() {
        var model = new DadosExemploDisjuntor();
        model.setCorrenteNominal(1);
        model.setNomeDisjuntor("A");
        return model;
    }

    public static DadosExemploEletroduto gerarExemploEletroduto() {
        var model = new DadosExemploEletroduto();
        model.setDiametroNominalMilimetros(1);
        model.setDiametroNominalPolegadas("A");
        model.setDiametroExterno(new BigDecimal("12000"));
        model.setDiametroInterno(new BigDecimal("10"));
        return model;
    }

    public static DadosBuscaExemploCondutor gerarDadosBuscaCondutor() {
        var model = new DadosBuscaExemploCondutor();
        model.setCabosCarregados(1);
        model.setSecaoNominal(BigDecimal.ONE);
        return model;
    }

    public static DadosBuscaExemploDisjuntor gerarDadosBuscaDisjuntor() {
        var model = new DadosBuscaExemploDisjuntor();
        model.setCondutoresCarregados(1);
        model.setCorrenteProjeto(BigDecimal.ONE);
        model.setCorrenteMaximaCabo(BigDecimal.ONE);
        return model;
    }

    public static DadosBuscaFatorTemperatura gerarDadosBuscaFatorTemperatura() {
        return new DadosBuscaFatorTemperatura(gerarDadosCircuito());
    }
}
