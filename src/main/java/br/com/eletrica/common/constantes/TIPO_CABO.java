package br.com.eletrica.common.constantes;

import java.math.BigDecimal;

public enum TIPO_CABO {
    PVC("PVC", BigDecimal.valueOf(0.0172)),
    EPR("EPR", BigDecimal.valueOf(0.0172)),
    ALUMINIO("ALUMINIO", BigDecimal.valueOf(0.02857)),
    COBRE("COBRE", BigDecimal.valueOf(0.0172));

    private final String descricao;
    private final BigDecimal resistividade;

    private TIPO_CABO(String descricao, BigDecimal resistividade) {
        this.descricao = descricao;
        this.resistividade = resistividade;
    }

    public String get() {
        return descricao;
    }

    public BigDecimal valorResistividade() {
        return resistividade;
    }
}
