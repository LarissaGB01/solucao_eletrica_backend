package br.com.eletrica.domain.model.api.resposta.calculo;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class CalculoEletroduto {
    private BigDecimal secaoNominalCabo = BigDecimal.ZERO;
    private Double diametroCabo;
    private Integer quantidadeCondutores;
    private BigDecimal diametroMinimoCalculado = BigDecimal.ZERO;
}
