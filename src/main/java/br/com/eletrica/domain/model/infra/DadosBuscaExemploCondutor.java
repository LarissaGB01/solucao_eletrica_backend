package br.com.eletrica.domain.model.infra;

import br.com.eletrica.domain.model.DadosCircuito;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class DadosBuscaExemploCondutor {
    private int cabosCarregados;
    private BigDecimal secaoNominal;

    public DadosBuscaExemploCondutor(DadosCircuito dadosCircuito, BigDecimal secaoCalculada) {
        this.cabosCarregados = dadosCircuito.getFasesVoltagem().getCabosCarregados();
        this.secaoNominal = secaoCalculada;
    }
}
