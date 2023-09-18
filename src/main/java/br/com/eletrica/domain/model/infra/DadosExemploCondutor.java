package br.com.eletrica.domain.model.infra;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class DadosExemploCondutor {
    private BigDecimal secaoNominal;
    private BigDecimal diametroNominalCondutor;
    private BigDecimal diametroNominalExterno;
}
