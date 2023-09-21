package br.com.eletrica.domain.services;

import br.com.eletrica.domain.model.api.resposta.calculo.CalculoPotenciaAparente;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class CalcularPotenciaService {

    public CalculoPotenciaAparente calcularAparente(BigDecimal potenciaAtiva, BigDecimal potenciaAparente, BigDecimal fatorDePotencia) {
        var dadosDeCalculo = new CalculoPotenciaAparente();
        dadosDeCalculo.setPotenciaAtiva(potenciaAtiva);
        dadosDeCalculo.setFatorDePotencia(fatorDePotencia);

        if (potenciaAtiva.compareTo(BigDecimal.ZERO) == 0) {
            dadosDeCalculo.setIndicadorPotenciaAparenteInformada(true);
            dadosDeCalculo.setPotenciaAparente(potenciaAparente);
        } else {
            dadosDeCalculo.setIndicadorPotenciaAparenteInformada(false);
            dadosDeCalculo.setPotenciaAparente(potenciaAtiva.divide(fatorDePotencia, RoundingMode.HALF_EVEN));
        }

        return dadosDeCalculo;
    }
}
