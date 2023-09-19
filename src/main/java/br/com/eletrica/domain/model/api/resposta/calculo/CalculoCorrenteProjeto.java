package br.com.eletrica.domain.model.api.resposta.calculo;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class CalculoCorrenteProjeto {
    private boolean indicadorCircuitoTrifasico;
    private BigDecimal potenciaAparente = BigDecimal.ZERO;
    private Integer voltagem;
    private BigDecimal correnteCircuito = BigDecimal.ZERO;
    private Integer quantidadeCircuitosAgrupados;
    private Double fatorAgrupamento;
    private Integer temperaturaAmbiente;
    private String isolacaoCabo;
    private BigDecimal fatorTemperatura = BigDecimal.ZERO;
    private BigDecimal correnteProjeto = BigDecimal.ZERO;
}
