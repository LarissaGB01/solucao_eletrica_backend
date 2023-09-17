package br.com.eletrica.domain.model.api.resposta.calculo;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class CalculoCorrenteProjeto {
    private boolean indicadorCircuitoTrifasico;
    private BigDecimal correnteCircuito = BigDecimal.ZERO;
    private BigDecimal correnteProjeto = BigDecimal.ZERO;
    private BigDecimal potenciaAparente = BigDecimal.ZERO;
    private Integer voltagem;
    private Integer quantidadeCircuitosAgrupados;
    private Integer temperaturaAmbiente;
    private String isolacaoCabo;
    private Double fatorAgrupamento;
    private BigDecimal fatorTemperatura = BigDecimal.ZERO;
}
