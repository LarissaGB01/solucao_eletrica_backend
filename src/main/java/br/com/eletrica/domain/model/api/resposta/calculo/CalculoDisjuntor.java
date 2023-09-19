package br.com.eletrica.domain.model.api.resposta.calculo;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class CalculoDisjuntor {
    private String fasesVoltagem;
    private Integer cabosCarregados;
    private BigDecimal correnteProjeto = BigDecimal.ZERO;
    private BigDecimal correnteMaximaCabo = BigDecimal.ZERO;
}
