package br.com.eletrica.domain.model.api.resposta.calculo;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class CalculoDiametroMinimoCabo {
    private Boolean indicadorCircuitoTrifasico;
    private Boolean indicadorMinimoDiametroUtilizado;
    private String tipoCabo;
    private String utilizacaoCircuito;
    private String tipoCircuito;
    private Integer comprimentoFio;
    private Integer valorVariacaoTensao;
    private Integer voltagem;
    private BigDecimal resistividadeCabo = BigDecimal.ZERO;
    private BigDecimal correnteProjeto = BigDecimal.ZERO;
    private BigDecimal minimoDiametroCabo = BigDecimal.ZERO;
    private BigDecimal diametroCalculado = BigDecimal.ZERO;
}
