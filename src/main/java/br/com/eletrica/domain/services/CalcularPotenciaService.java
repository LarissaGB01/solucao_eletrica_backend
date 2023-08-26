package br.com.eletrica.domain.services;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CalcularPotenciaService {

    public static BigDecimal calcularAparente(BigDecimal potenciaAtiva, BigDecimal potenciaReativa, BigDecimal fatorDePotencia) {
        if (potenciaAtiva.compareTo(BigDecimal.ZERO) == 0) {
            return potenciaReativa;
        }
        return potenciaAtiva.divide(fatorDePotencia, RoundingMode.DOWN);
    }
}
