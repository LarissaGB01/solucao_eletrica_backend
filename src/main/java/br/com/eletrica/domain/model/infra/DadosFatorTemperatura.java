package br.com.eletrica.domain.model.infra;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class DadosFatorTemperatura {
    private BigDecimal temperatura;
    private String isolacao;
    private BigDecimal fatorCorrecao;
}
