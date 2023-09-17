package br.com.eletrica.domain.model.infra;

import br.com.eletrica.domain.model.DadosCircuito;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class DadosExemploCondutor {
    private int cabosCarregados;
    private BigDecimal secaoNominal;
    private BigDecimal diametroNominalCondutor;
    private BigDecimal diametroNominalExterno;

    public DadosExemploCondutor(DadosCircuito dadosCircuito, BigDecimal secaoCalculada) {
        this.cabosCarregados = dadosCircuito.getFasesVoltagem().getCabosCarregados();
        this.secaoNominal = secaoCalculada;
    }
}
