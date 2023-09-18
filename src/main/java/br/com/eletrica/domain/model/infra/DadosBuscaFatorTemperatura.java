package br.com.eletrica.domain.model.infra;

import br.com.eletrica.domain.model.DadosCircuito;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class DadosBuscaFatorTemperatura {
    private BigDecimal temperatura;
    private String isolacao;

    public DadosBuscaFatorTemperatura(DadosCircuito dadosCircuito) {
        this.temperatura = BigDecimal.valueOf(dadosCircuito.getTemperaturaAmbiente());
        this.isolacao = dadosCircuito.getTipoCabo().getIsolamento();
    }
}
