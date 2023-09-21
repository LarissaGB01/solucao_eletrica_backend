package br.com.eletrica.domain.model;

import br.com.eletrica.common.constantes.*;
import br.com.eletrica.domain.model.infra.DadosBuscaFatorTemperatura;
import br.com.eletrica.fixtures.ModelFixture;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class DadosCircuitoTest {

    @Test
    public void testaModelo() {
        var model = new DadosCircuito();

        model.setUtilizacaoCircuito(TIPO_UTILIZACAO.TOMADA);
        model.setTipoCircuito(TIPO_CIRCUITO.DISTRIBUICAO);
        model.setFasesVoltagem(FASES_VOLTAGEM.TRIFASICO);
        model.setVoltagem(380);
        model.setMetodoInstalacao(METODO_INSTALACAO.A1);
        model.setTipoCabo(TIPO_CABO.ALUMINIO);
        model.setPotenciaAtiva(new BigDecimal("12000"));
        model.setPotenciaAparente(new BigDecimal("0"));
        model.setFatorDePotencia(new BigDecimal("0.8"));
        model.setTemperaturaAmbiente(50);
        model.setQuantidadeCircuitosAgrupados(2);
        model.setComprimentoFio(60);

        assertNotNull(model.getUtilizacaoCircuito());
        assertNotNull(model.getTipoCircuito());
        assertNotNull(model.getFasesVoltagem());
        assertNotNull(model.getVoltagem());
        assertNotNull(model.getMetodoInstalacao());
        assertNotNull(model.getTipoCabo());
        assertNotNull(model.getPotenciaAtiva());
        assertNotNull(model.getPotenciaAparente());
        assertNotNull(model.getFatorDePotencia());
        assertNotNull(model.getTemperaturaAmbiente());
        assertNotNull(model.getQuantidadeCircuitosAgrupados());
        assertNotNull(model.getComprimentoFio());
    }
}