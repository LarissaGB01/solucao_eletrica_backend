package br.com.eletrica.domain.model.infra;

import br.com.eletrica.domain.model.api.resposta.DadosCircuito;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class DadosFatorTemperatura {
    private BigDecimal temperatura;
    private String isolacao;
    private BigDecimal fatorCorrecao;

    public DadosFatorTemperatura(DadosCircuito dadosCircuito) {
        this.temperatura = BigDecimal.valueOf(dadosCircuito.getTemperaturaAmbiente());
        this.isolacao = dadosCircuito.getTipoCabo().getIsolamento();
    }
}
