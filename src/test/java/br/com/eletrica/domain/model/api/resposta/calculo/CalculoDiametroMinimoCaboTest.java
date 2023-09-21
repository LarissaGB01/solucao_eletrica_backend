package br.com.eletrica.domain.model.api.resposta.calculo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.math.BigDecimal;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CalculoDiametroMinimoCaboTest {

    @Test
    public void testaModelo() {
        var modelo = new CalculoDiametroMinimoCabo();

        modelo.setTipoCabo("Cabo de Cobre");
        modelo.setResistividadeCabo(new BigDecimal("0.0175"));
        modelo.setTipoCircuito("Circuito Monofásico");
        modelo.setIndicadorCircuitoTrifasico(false);
        modelo.setComprimentoFio(50);
        modelo.setCorrenteProjeto(new BigDecimal("25.0"));
        modelo.setValorVariacaoTensao(5);
        modelo.setVoltagem(220);
        modelo.setDiametroCalculado(new BigDecimal("2.5"));
        modelo.setUtilizacaoCircuito("Iluminação");
        modelo.setMinimoDiametroCabo(new BigDecimal("2.5"));
        modelo.setIndicadorMinimoDiametroUtilizado(true);
        modelo.setFasesVoltagem("Monofásico 220V");
        modelo.setCabosCarregados(1);
        modelo.setMetodoInstalacao("Eletroduto");
        modelo.setMaterialCabo("Cobre");
        modelo.setIsolamentoCabo("THW");

        Assertions.assertNotNull(modelo.getTipoCabo());
        Assertions.assertNotNull(modelo.getResistividadeCabo());
        Assertions.assertNotNull(modelo.getTipoCircuito());
        Assertions.assertNotNull(modelo.getIndicadorCircuitoTrifasico());
        Assertions.assertNotNull(modelo.getComprimentoFio());
        Assertions.assertNotNull(modelo.getCorrenteProjeto());
        Assertions.assertNotNull(modelo.getValorVariacaoTensao());
        Assertions.assertNotNull(modelo.getVoltagem());
        Assertions.assertNotNull(modelo.getDiametroCalculado());
        Assertions.assertNotNull(modelo.getUtilizacaoCircuito());
        Assertions.assertNotNull(modelo.getMinimoDiametroCabo());
        Assertions.assertNotNull(modelo.getIndicadorMinimoDiametroUtilizado());
        Assertions.assertNotNull(modelo.getFasesVoltagem());
        Assertions.assertNotNull(modelo.getCabosCarregados());
        Assertions.assertNotNull(modelo.getMetodoInstalacao());
        Assertions.assertNotNull(modelo.getMaterialCabo());
        Assertions.assertNotNull(modelo.getIsolamentoCabo());
    }
}