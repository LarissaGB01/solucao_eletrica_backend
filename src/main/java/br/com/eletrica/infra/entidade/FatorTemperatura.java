package br.com.eletrica.infra.entidade;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class FatorTemperatura {
    private Integer temperatura;
    private String isolacao;
    private BigDecimal fatorCorrecao;

    public static String queryConsultar() {
        return "SELECT fator_correcao " +
                "FROM " +
                "   normativas.fator_temperatura " +
                "WHERE " +
                "   temperatura >= ? AND " +
                "   isolacao = ? " +
                "ORDER BY temperatura ASC " +
                "LIMIT 1";
    }

    public static String getNomeTabela() {
        return "fator_temperatura";
    }

    public static String getNomeColunaTemperatura() {
        return "temperatura";
    }

    public static String getNomeColunaIsolacao() {
        return "isolacao";
    }

    public static String getNomeColunaFatorCorrecao() {
        return "fator_correcao";
    }
}
