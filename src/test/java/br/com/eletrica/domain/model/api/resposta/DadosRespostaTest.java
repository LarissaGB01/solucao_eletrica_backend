package br.com.eletrica.domain.model.api.resposta;

import br.com.eletrica.domain.model.api.resposta.calculo.DadosUtilizadosParaCalculo;
import br.com.eletrica.domain.model.api.resposta.dimensionado.DadosDimensionados;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class DadosRespostaTest {

    @Test
    public void testaModelo() {
        var modelo = new DadosResposta();

        modelo.setDadosUtilizadosParaCalculo(new DadosUtilizadosParaCalculo());
        modelo.setDadosDimensionados(new DadosDimensionados());

        assertNotNull(modelo.getDadosUtilizadosParaCalculo());
        assertNotNull(modelo.getDadosDimensionados());
    }

}