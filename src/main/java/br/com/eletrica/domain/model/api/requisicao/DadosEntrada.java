package br.com.eletrica.domain.model.api.requisicao;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class DadosEntrada {

    private String utilizacaoCircuito;
    private String tipoCircuito;
    private String fasesVoltagem;
    private Integer voltagem;
    private String metodoInstalacao;
    private String tipoCabo;
    private BigDecimal potenciaAtiva;
    private BigDecimal potenciaAparente;
    private BigDecimal fatorDePotencia;
    private Integer temperaturaAmbiente;
    private Integer quantidadeCircuitosAgrupados;
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
