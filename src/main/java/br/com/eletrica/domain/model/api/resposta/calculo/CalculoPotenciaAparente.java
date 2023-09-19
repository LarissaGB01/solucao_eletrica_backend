package br.com.eletrica.domain.model.api.resposta.calculo;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class CalculoPotenciaAparente {
    private Boolean indicadorPotenciaAparenteInformada;
    private BigDecimal potenciaAtiva = BigDecimal.ZERO;
    private BigDecimal fatorDePotencia = BigDecimal.ZERO;
    private BigDecimal potenciaAparente = BigDecimal.ZERO;
}
