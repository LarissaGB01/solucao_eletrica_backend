package br.com.eletrica.domain.model.api.resposta;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class DadosCabeamento {
    private BigDecimal correnteCabo = BigDecimal.ZERO;
    private BigDecimal diametroCabo = BigDecimal.ZERO;
}
