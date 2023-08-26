package br.com.eletrica.infra.entidade;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class FatorTemperatura {
    private Integer temperatura;
    private BigDecimal isolacao;
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
}
