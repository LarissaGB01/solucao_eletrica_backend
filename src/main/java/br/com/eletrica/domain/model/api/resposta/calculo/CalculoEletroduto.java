package br.com.eletrica.domain.model.api.resposta.calculo;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class CalculoEletroduto {
    private Integer quantidadeCondutores;
    private BigDecimal diametroCabo = BigDecimal.ZERO;
    private BigDecimal diametroMinimoCalculado = BigDecimal.ZERO;
}
