package br.com.eletrica.domain.model.api.resposta;

import br.com.eletrica.domain.model.api.resposta.calculo.CalculoDisjuntor;
import br.com.eletrica.domain.model.api.resposta.calculo.DadosUtilizadosParaCalculo;
import br.com.eletrica.domain.model.api.resposta.dimensionado.DadosDimensionados;
import br.com.eletrica.domain.model.api.resposta.dimensionado.DadosDisjuntor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class DadosRespostaDisjuntoresTest {

    @Test
    public void testaModelo() {
        var modelo = new DadosRespostaDisjuntores();

        modelo.setDisjuntor(new DadosDisjuntor());
        modelo.setDadosUtilizadosParaCalculo(new CalculoDisjuntor());

        assertNotNull(modelo.getDisjuntor());
        assertNotNull(modelo.getDadosUtilizadosParaCalculo());
    }

}