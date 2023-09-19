package br.com.eletrica.domain.model.api.resposta.calculo;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class CalculoDiametroMinimoCabo {
    private String tipoCabo;
    private BigDecimal resistividadeCabo = BigDecimal.ZERO;
    private String tipoCircuito;
    private Boolean indicadorCircuitoTrifasico;
    private Integer comprimentoFio;
    private BigDecimal correnteProjeto = BigDecimal.ZERO;
    private Integer valorVariacaoTensao;
    private Integer voltagem;
    private BigDecimal diametroCalculado = BigDecimal.ZERO;
    private String utilizacaoCircuito;
    private BigDecimal minimoDiametroCabo = BigDecimal.ZERO;
    private Boolean indicadorMinimoDiametroUtilizado;
    private String fasesVoltagem;
    private Integer cabosCarregados;
    private String metodoInstalacao;
    private String materialCabo;
    private String isolamentoCabo;
}
