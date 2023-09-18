package br.com.eletrica.domain.model.infra;

import br.com.eletrica.common.constantes.FASES_VOLTAGEM;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class DadosBuscaExemploDisjuntor {
    private BigDecimal correnteMaximaCabo = BigDecimal.ZERO;
    private BigDecimal correnteProjeto = BigDecimal.ZERO;
    private int condutoresCarregados;

    public DadosBuscaExemploDisjuntor(FASES_VOLTAGEM fasesVoltagem, BigDecimal correnteProjeto, BigDecimal correnteMaximaCabo) {
        this.condutoresCarregados = fasesVoltagem.getCabosCarregados();
        this.correnteMaximaCabo = correnteMaximaCabo;
        this.correnteProjeto = correnteProjeto;
    }
}
