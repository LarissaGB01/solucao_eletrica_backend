package br.com.eletrica.domain.model.api.requisicao;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
public class DadosEntrada {

    @Id
    @ApiModelProperty(required = true, example = "TOMADA")
    private String utilizacaoCircuito;

    @ApiModelProperty(required = true, example = "DISTRIBUICAO")
    private String tipoCircuito;

    @ApiModelProperty(required = true, example = "TRIFASICO")
    private String fasesVoltagem;

    @ApiModelProperty(required = true, example = "380")
    private Integer voltagem;

    @ApiModelProperty(required = true, example = "A1")
    private String metodoInstalacao;

    @ApiModelProperty(required = true, example = "ALUMINIO")
    private String tipoCabo;

    @ApiModelProperty(required = false, example = "12000")
    private BigDecimal potenciaAtiva;

    @ApiModelProperty(required = false, example = "0")
    private BigDecimal potenciaAparente;

    @ApiModelProperty(required = false, example = "0.8")
    private BigDecimal fatorDePotencia;

    @ApiModelProperty(required = true, example = "50")
    private Integer temperaturaAmbiente;

    @ApiModelProperty(required = true, example = "2")
    private Integer quantidadeCircuitosAgrupados;

    @ApiModelProperty(required = true, example = "60")
    private Integer comprimentoFio;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        var stringObjetoNulo = "null";

        sb.append("Circuito de ");
        sb.append(tipoCircuito != null ? tipoCircuito.toLowerCase() : stringObjetoNulo);
        sb.append(" utilizado para ");
        sb.append(utilizacaoCircuito != null ? utilizacaoCircuito.toLowerCase() : stringObjetoNulo);
        sb.append(". Opera em um sistema ");
        sb.append(fasesVoltagem != null ? fasesVoltagem.toLowerCase() : stringObjetoNulo);
        sb.append(" de ");
        sb.append(voltagem != null ? voltagem + "V" : stringObjetoNulo);
        sb.append(", ");
        sb.append(potenciaAparente != null ? potenciaAparente + "VA" : stringObjetoNulo);
        sb.append(" e ");
        sb.append(potenciaAtiva != null ? potenciaAtiva + "W" : stringObjetoNulo);
        sb.append(" com fator de potência ");
        sb.append(fatorDePotencia != null ? fatorDePotencia.toString() : stringObjetoNulo);
        sb.append(". A instalação seguirá o método ");
        sb.append(metodoInstalacao != null ? metodoInstalacao : stringObjetoNulo);
        sb.append(" com cabos de ");
        sb.append(tipoCabo != null ? tipoCabo : stringObjetoNulo);
        sb.append(" em uma temperatura ambiente de ");
        sb.append(temperaturaAmbiente != null ? temperaturaAmbiente + " graus Celsius" : stringObjetoNulo);
        sb.append(". Os circuitos terão ");
        sb.append(quantidadeCircuitosAgrupados != null ? quantidadeCircuitosAgrupados : stringObjetoNulo);
        sb.append(" cabos e o comprimento total dos mesmos será de ");
        sb.append(comprimentoFio != null ? comprimentoFio + " metros" : stringObjetoNulo);
        sb.append(".");

        return sb.toString();
    }
}
