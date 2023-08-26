package br.com.eletrica.common.constantes;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public enum TIPO_UTILIZACAO {
    TOMADA("TOMADA", 2.5),
    ILUMINACAO("ILUMINACAO", 1.5);

    private final String descricao;
    private final Double valorMinimoDiametro;

    private TIPO_UTILIZACAO(String descricao, Double valorMinimoDiametro) {
        this.descricao = descricao;
        this.valorMinimoDiametro = valorMinimoDiametro;
    }

    public String get() {
        return descricao;
    }

    public BigDecimal getMinimoDiametroCabo() {
        return BigDecimal.valueOf(valorMinimoDiametro);
    }
}
