package br.com.eletrica.domain.model.api.requisicao;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class DadosEntradaDisjuntores {
    private BigDecimal correnteProjeto = BigDecimal.ZERO;
    private BigDecimal correnteMaximaCabo = BigDecimal.ZERO;
    private String fasesVoltagem;
}
