package br.com.eletrica.domain.model.api.resposta;

import br.com.eletrica.domain.model.api.resposta.calculo.CalculoDisjuntor;
import br.com.eletrica.domain.model.api.resposta.calculo.CalculoEletroduto;
import br.com.eletrica.domain.model.api.resposta.dimensionado.DadosDisjuntor;
import br.com.eletrica.domain.model.api.resposta.dimensionado.DadosEletroduto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class DadosRespostaEletrodutoTest {

    @Test
    public void testaModelo() {
        var modelo = new DadosRespostaEletroduto();

        modelo.setEletroduto(new DadosEletroduto());
        modelo.setDadosUtilizadosParaCalculo(new CalculoEletroduto());

        assertNotNull(modelo.getEletroduto());
        assertNotNull(modelo.getDadosUtilizadosParaCalculo());
    }

}