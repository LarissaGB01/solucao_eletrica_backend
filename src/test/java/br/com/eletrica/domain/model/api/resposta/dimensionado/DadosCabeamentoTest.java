package br.com.eletrica.domain.model.api.resposta.dimensionado;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class DadosCabeamentoTest {

    @Test
    public void testaModelo() {
        var modelo = new DadosCabeamento();

        modelo.setCorrenteMaximaCondutor(BigDecimal.ONE);
        modelo.setDiametroNominalCaboRecomendado(BigDecimal.ONE);
        modelo.setDiametroExternoCaboRecomendado(BigDecimal.ONE);
        modelo.setSecaoNominalCondutor(BigDecimal.ONE);

        assertNotNull(modelo.getCorrenteMaximaCondutor());
        assertNotNull(modelo.getDiametroNominalCaboRecomendado());
        assertNotNull(modelo.getDiametroExternoCaboRecomendado());
        assertNotNull(modelo.getSecaoNominalCondutor());
    }
}