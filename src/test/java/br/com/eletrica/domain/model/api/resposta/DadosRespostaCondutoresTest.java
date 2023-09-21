package br.com.eletrica.domain.model.api.resposta;

import br.com.eletrica.domain.model.api.resposta.calculo.CalculoEletroduto;
import br.com.eletrica.domain.model.api.resposta.calculo.CalculoSecaoCondutor;
import br.com.eletrica.domain.model.api.resposta.dimensionado.DadosCabeamento;
import br.com.eletrica.domain.model.api.resposta.dimensionado.DadosEletroduto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class DadosRespostaCondutoresTest {

    @Test
    public void testaModelo() {
        var modelo = new DadosRespostaCondutores();

        modelo.setCabeamento(new DadosCabeamento());
        modelo.setDadosUtilizadosParaCalculo(new CalculoSecaoCondutor());

        assertNotNull(modelo.getCabeamento());
        assertNotNull(modelo.getDadosUtilizadosParaCalculo());
    }
}