package br.com.eletrica.domain.services;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class CalcularPotenciaService {

    public static BigDecimal calcularAparente(BigDecimal potenciaAtiva, BigDecimal potenciaAparente, BigDecimal fatorDePotencia) {
        if (potenciaAtiva.compareTo(BigDecimal.ZERO) == 0) {
            return potenciaAparente;
        }
        return potenciaAtiva.divide(fatorDePotencia, RoundingMode.HALF_EVEN);
    }
}
