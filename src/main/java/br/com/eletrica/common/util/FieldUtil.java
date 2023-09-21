package br.com.eletrica.common.util;

import java.math.BigDecimal;
import java.util.EnumSet;

public class FieldUtil {
    public static <E extends Enum<E>> String listarEnums(Class<E> enumClass) {
        var sb = new StringBuilder();

        for (E enumValue : enumClass.getEnumConstants()) {
            sb.append(enumValue.toString());
            sb.append(", ");
        }

        var resposta = sb.toString();
        return resposta.substring(0, resposta.length() - 2);
    }

    public static <E extends Enum<E>> boolean enumNaoContem(Class<E> enumClass, String value) {
        EnumSet<E> enumSet = EnumSet.allOf(enumClass);
        for (E enumValue : enumSet) {
            if (enumValue.name().equals(value)) {
                return false;
            }
        }
        return true;
    }

    public static boolean campoPreenchido(Object campo) {
        if (campo == null) {
            return false;
        }

        if (campo instanceof String) {
            String texto = (String) campo;
            return !texto.trim().isEmpty();
        }

        if (campo instanceof Number) {
            if (campo instanceof Integer) {
                return ((Integer) campo) != 0;
            }
            if (campo instanceof BigDecimal) {
                return ((BigDecimal) campo).compareTo(BigDecimal.ZERO) != 0;
            }
            if (campo instanceof Float) {
                return ((Float) campo) != 0;
            }
        }

        return true;
    }
}
