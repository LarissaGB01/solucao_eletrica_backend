package br.com.eletrica.common.util;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.*;

public class FieldUtilTest {

    @Test
    public void testListarEnums() {
        var fieldUtil = new FieldUtil();
        String enumList = FieldUtil.listarEnums(TestEnum.class);
        assertEquals("VALUE1, VALUE2, VALUE3", enumList);
    }

    @Test
    public void testEnumContem() {
        assertFalse(FieldUtil.enumNaoContem(TestEnum.class, "VALUE1"));
        assertTrue(FieldUtil.enumNaoContem(TestEnum.class, "INVALID_VALUE"));
    }

    @Test
    public void testCampoPreenchido() {

        // string
        assertTrue(FieldUtil.campoPreenchido("Texto não vazio"));
        assertFalse(FieldUtil.campoPreenchido(""));

        // int
        assertTrue(FieldUtil.campoPreenchido(123));
        assertFalse(FieldUtil.campoPreenchido(0));

        // float
        assertTrue(FieldUtil.campoPreenchido(123F));
        assertFalse(FieldUtil.campoPreenchido(0F));

        // boleano
        assertTrue(FieldUtil.campoPreenchido(true));
        assertTrue(FieldUtil.campoPreenchido(false));

        // BigDecimal
        assertTrue(FieldUtil.campoPreenchido(new BigDecimal("1.23")));
        assertFalse(FieldUtil.campoPreenchido(BigDecimal.ZERO));

        // nulo
        assertFalse(FieldUtil.campoPreenchido(null));
    }

    private enum TestEnum {
        VALUE1, VALUE2, VALUE3
    }
}
