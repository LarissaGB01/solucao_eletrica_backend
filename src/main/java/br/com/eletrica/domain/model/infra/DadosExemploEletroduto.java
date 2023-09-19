package br.com.eletrica.domain.model.infra;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class DadosExemploEletroduto {
    private String diametroNominalPolegadas;
    private int diametroNominalMilimetros;
    private BigDecimal diametroExterno;
    private BigDecimal diametroInterno;
}
