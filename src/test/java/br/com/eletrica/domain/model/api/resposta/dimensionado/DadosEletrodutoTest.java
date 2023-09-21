package br.com.eletrica.domain.model.api.resposta.dimensionado;

import br.com.eletrica.domain.model.api.resposta.DadosRespostaCondutores;
import br.com.eletrica.domain.model.api.resposta.calculo.CalculoSecaoCondutor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class DadosEletrodutoTest {

    @Test
    public void testaModelo() {
        var modelo = new DadosEletroduto();

        modelo.setDiametroExternoEletrodutoSugerido(BigDecimal.ONE);
        modelo.setDiametroInternoEletrodutoSugerido(BigDecimal.ONE);
        modelo.setDiametroNominalEletrodutoSugeridoMilimetros(1);
        modelo.setDiametroNominalEletrodutoSugeridoPolegadas("a");

        assertNotNull(modelo.getDiametroExternoEletrodutoSugerido());
        assertNotNull(modelo.getDiametroInternoEletrodutoSugerido());
        assertNotNull(modelo.getDiametroNominalEletrodutoSugeridoMilimetros());
        assertNotNull(modelo.getDiametroNominalEletrodutoSugeridoPolegadas());
    }
}