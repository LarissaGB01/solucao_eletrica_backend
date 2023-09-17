package br.com.eletrica.domain.model.infra;

import br.com.eletrica.domain.model.DadosCircuito;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class DadosConducaoCabos {
    private String material;
    private BigDecimal secaoNominal;
    private String instalacao;
    private Integer condutoresCarregados;
    private BigDecimal correnteNominal;
    private String isolamento;

    public DadosConducaoCabos(DadosCircuito dadosCircuito, BigDecimal secaoCalculada) {
        this.instalacao = dadosCircuito.getMetodoInstalacao().get();
        this.secaoNominal = secaoCalculada;
        this.correnteNominal = dadosCircuito.getCorrenteProjeto();
        this.condutoresCarregados = dadosCircuito.getQuantidadeCircuitosAgrupados();
        this.material = dadosCircuito.getTipoCabo().getMaterial();
        this.isolamento = dadosCircuito.getTipoCabo().getIsolamento();
    }
}
