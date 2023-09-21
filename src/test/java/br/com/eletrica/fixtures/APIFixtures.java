package br.com.eletrica.fixtures;

import br.com.eletrica.domain.model.api.requisicao.DadosEntrada;
import br.com.eletrica.domain.model.api.requisicao.DadosEntradaDisjuntores;
import br.com.eletrica.domain.model.api.requisicao.DadosEntradaEletrodutos;
import br.com.eletrica.domain.model.api.resposta.DadosResposta;
import br.com.eletrica.domain.model.api.resposta.calculo.CalculoCorrenteProjeto;
import br.com.eletrica.domain.model.api.resposta.calculo.CalculoDiametroMinimoCabo;

import java.math.BigDecimal;

public class APIFixtures {
    public static DadosResposta gerarRespostaGeral() {
        var resposta = new DadosResposta();

        // Preencha os campos de DadosDimensionados
        resposta.getDadosDimensionados().getCabeamento().setCorrenteMaximaCondutor(new BigDecimal("100.0"));
        resposta.getDadosDimensionados().getCabeamento().setSecaoNominalCondutor(new BigDecimal("2.5"));
        resposta.getDadosDimensionados().getCabeamento().setDiametroExternoCaboRecomendado(new BigDecimal("8.0"));
        resposta.getDadosDimensionados().getCabeamento().setDiametroNominalCaboRecomendado(new BigDecimal("6.0"));

        resposta.getDadosDimensionados().getDisjuntor().setCorrenteNominalDisjuntorRecomendado(30);
        resposta.getDadosDimensionados().getDisjuntor().setNomeDisjuntorRecomendado("Disjuntor A");

        resposta.getDadosDimensionados().getEletroduto().setDiametroNominalEletrodutoSugeridoPolegadas("2");
        resposta.getDadosDimensionados().getEletroduto().setDiametroNominalEletrodutoSugeridoMilimetros(50);
        resposta.getDadosDimensionados().getEletroduto().setDiametroExternoEletrodutoSugerido(new BigDecimal("54.0"));
        resposta.getDadosDimensionados().getEletroduto().setDiametroInternoEletrodutoSugerido(new BigDecimal("48.0"));

        // Preencha os campos de DadosUtilizadosParaCalculo
        resposta.getDadosUtilizadosParaCalculo().getCalculoSecaoCondutor().getCalculoPotenciaAparente().setIndicadorPotenciaAparenteInformada(true);
        resposta.getDadosUtilizadosParaCalculo().getCalculoSecaoCondutor().getCalculoPotenciaAparente().setPotenciaAtiva(new BigDecimal("5000.0"));
        resposta.getDadosUtilizadosParaCalculo().getCalculoSecaoCondutor().getCalculoPotenciaAparente().setFatorDePotencia(new BigDecimal("0.9"));
        resposta.getDadosUtilizadosParaCalculo().getCalculoSecaoCondutor().getCalculoPotenciaAparente().setPotenciaAparente(new BigDecimal("5555.0"));

        resposta.getDadosUtilizadosParaCalculo().getCalculoSecaoCondutor().getCalculoCorrenteProjeto().setIndicadorCircuitoTrifasico(true);
        resposta.getDadosUtilizadosParaCalculo().getCalculoSecaoCondutor().getCalculoCorrenteProjeto().setPotenciaAparente(new BigDecimal("5555.0"));
        resposta.getDadosUtilizadosParaCalculo().getCalculoSecaoCondutor().getCalculoCorrenteProjeto().setVoltagem(220);
        resposta.getDadosUtilizadosParaCalculo().getCalculoSecaoCondutor().getCalculoCorrenteProjeto().setCorrenteCircuito(new BigDecimal("25.0"));
        resposta.getDadosUtilizadosParaCalculo().getCalculoSecaoCondutor().getCalculoCorrenteProjeto().setQuantidadeCircuitosAgrupados(1);
        resposta.getDadosUtilizadosParaCalculo().getCalculoSecaoCondutor().getCalculoCorrenteProjeto().setFatorAgrupamento(1.0);
        resposta.getDadosUtilizadosParaCalculo().getCalculoSecaoCondutor().getCalculoCorrenteProjeto().setTemperaturaAmbiente(25);
        resposta.getDadosUtilizadosParaCalculo().getCalculoSecaoCondutor().getCalculoCorrenteProjeto().setIsolacaoCabo("THW");
        resposta.getDadosUtilizadosParaCalculo().getCalculoSecaoCondutor().getCalculoCorrenteProjeto().setFatorTemperatura(new BigDecimal("1.0"));
        resposta.getDadosUtilizadosParaCalculo().getCalculoSecaoCondutor().getCalculoCorrenteProjeto().setCorrenteProjeto(new BigDecimal("25.0"));

        resposta.getDadosUtilizadosParaCalculo().getCalculoSecaoCondutor().getCalculoDiametroMinimoCabo().setTipoCabo("Cabo de Cobre");
        resposta.getDadosUtilizadosParaCalculo().getCalculoSecaoCondutor().getCalculoDiametroMinimoCabo().setResistividadeCabo(new BigDecimal("0.0175"));
        resposta.getDadosUtilizadosParaCalculo().getCalculoSecaoCondutor().getCalculoDiametroMinimoCabo().setTipoCircuito("Circuito Monofásico");
        resposta.getDadosUtilizadosParaCalculo().getCalculoSecaoCondutor().getCalculoDiametroMinimoCabo().setIndicadorCircuitoTrifasico(false);
        resposta.getDadosUtilizadosParaCalculo().getCalculoSecaoCondutor().getCalculoDiametroMinimoCabo().setComprimentoFio(50);
        resposta.getDadosUtilizadosParaCalculo().getCalculoSecaoCondutor().getCalculoDiametroMinimoCabo().setCorrenteProjeto(new BigDecimal("25.0"));
        resposta.getDadosUtilizadosParaCalculo().getCalculoSecaoCondutor().getCalculoDiametroMinimoCabo().setValorVariacaoTensao(5);
        resposta.getDadosUtilizadosParaCalculo().getCalculoSecaoCondutor().getCalculoDiametroMinimoCabo().setVoltagem(220);
        resposta.getDadosUtilizadosParaCalculo().getCalculoSecaoCondutor().getCalculoDiametroMinimoCabo().setDiametroCalculado(new BigDecimal("2.5"));
        resposta.getDadosUtilizadosParaCalculo().getCalculoSecaoCondutor().getCalculoDiametroMinimoCabo().setUtilizacaoCircuito("Iluminação");
        resposta.getDadosUtilizadosParaCalculo().getCalculoSecaoCondutor().getCalculoDiametroMinimoCabo().setMinimoDiametroCabo(new BigDecimal("2.5"));
        resposta.getDadosUtilizadosParaCalculo().getCalculoSecaoCondutor().getCalculoDiametroMinimoCabo().setIndicadorMinimoDiametroUtilizado(true);
        resposta.getDadosUtilizadosParaCalculo().getCalculoSecaoCondutor().getCalculoDiametroMinimoCabo().setFasesVoltagem("Monofásico 220V");
        resposta.getDadosUtilizadosParaCalculo().getCalculoSecaoCondutor().getCalculoDiametroMinimoCabo().setCabosCarregados(1);
        resposta.getDadosUtilizadosParaCalculo().getCalculoSecaoCondutor().getCalculoDiametroMinimoCabo().setMetodoInstalacao("Eletroduto");
        resposta.getDadosUtilizadosParaCalculo().getCalculoSecaoCondutor().getCalculoDiametroMinimoCabo().setMaterialCabo("Cobre");
        resposta.getDadosUtilizadosParaCalculo().getCalculoSecaoCondutor().getCalculoDiametroMinimoCabo().setIsolamentoCabo("THW");

        return resposta;
    }

    public static DadosEntrada gerarRequisicaoGeral() {
        var requisicao = new DadosEntrada();

        requisicao.setUtilizacaoCircuito("TOMADA");
        requisicao.setTipoCircuito("DISTRIBUICAO");
        requisicao.setFasesVoltagem("TRIFASICO");
        requisicao.setVoltagem(380);
        requisicao.setMetodoInstalacao("A1");
        requisicao.setTipoCabo("ALUMINIO");
        requisicao.setPotenciaAtiva(new BigDecimal("12000"));
        requisicao.setPotenciaAparente(new BigDecimal("0"));
        requisicao.setFatorDePotencia(new BigDecimal("0.8"));
        requisicao.setTemperaturaAmbiente(50);
        requisicao.setQuantidadeCircuitosAgrupados(2);
        requisicao.setComprimentoFio(60);

        return requisicao;
    }

    public static DadosEntradaDisjuntores gerarRequisicaoDisjuntores() {
        var requisicao = new DadosEntradaDisjuntores();

        requisicao.setFasesVoltagem("TRIFASICO");
        requisicao.setCorrenteProjeto(new BigDecimal("12000"));
        requisicao.setCorrenteMaximaCabo(new BigDecimal("15000"));

        return requisicao;
    }

    public static DadosEntradaEletrodutos gerarRequisicaoEletrodutos() {
        var requisicao = new DadosEntradaEletrodutos();

        requisicao.setSecaoNominalCabo(new BigDecimal("0.8"));
        requisicao.setQuantidadeCondutores(2);

        return requisicao;
    }

    public static CalculoCorrenteProjeto gerarCalculoCorrenteProjeto() {
        var resposta = new CalculoCorrenteProjeto();

        resposta.setIndicadorCircuitoTrifasico(true);
        resposta.setPotenciaAparente(new BigDecimal("5555.0"));
        resposta.setVoltagem(220);
        resposta.setCorrenteCircuito(new BigDecimal("25.0"));
        resposta.setQuantidadeCircuitosAgrupados(1);
        resposta.setFatorAgrupamento(1.0);
        resposta.setTemperaturaAmbiente(25);
        resposta.setIsolacaoCabo("THW");
        resposta.setFatorTemperatura(new BigDecimal("1.0"));
        resposta.setCorrenteProjeto(new BigDecimal("25.0"));

        return resposta;
    }

    public static CalculoDiametroMinimoCabo gerarCalculoCabeamento() {
        var resposta = new CalculoDiametroMinimoCabo();

        resposta.setTipoCabo("Cabo de Cobre");
        resposta.setResistividadeCabo(new BigDecimal("0.0175"));
        resposta.setTipoCircuito("Circuito Monofásico");
        resposta.setIndicadorCircuitoTrifasico(false);
        resposta.setComprimentoFio(50);
        resposta.setCorrenteProjeto(new BigDecimal("25.0"));
        resposta.setValorVariacaoTensao(5);
        resposta.setVoltagem(220);
        resposta.setDiametroCalculado(new BigDecimal("2.5"));
        resposta.setUtilizacaoCircuito("Iluminação");
        resposta.setMinimoDiametroCabo(new BigDecimal("2.5"));
        resposta.setIndicadorMinimoDiametroUtilizado(true);
        resposta.setFasesVoltagem("Monofásico 220V");
        resposta.setCabosCarregados(1);
        resposta.setMetodoInstalacao("Eletroduto");
        resposta.setMaterialCabo("Cobre");
        resposta.setIsolamentoCabo("THW");

        return resposta;
    }
}

