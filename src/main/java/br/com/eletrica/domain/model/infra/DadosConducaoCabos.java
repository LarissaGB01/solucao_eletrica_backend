package br.com.eletrica.domain.model.infra;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class DadosConducaoCabos {
    private String material;
    private BigDecimal secaoNominal;
    private String instalacao;
    private Integer condutoresCarregados;
    private BigDecimal correnteNominal;
    private String isolamento;
}
