package br.com.eletrica.common.constantes;

import java.math.BigDecimal;

public enum TIPO_CABO {
    PVC("COBRE", "PVC", BigDecimal.valueOf(0.0172)),
    EPR("COBRE", "EPR", BigDecimal.valueOf(0.0172)),
    ALUMINIO("ALUMINIO", "PVC", BigDecimal.valueOf(0.02857));

    private final String material;
    private final BigDecimal resistividade;
    private final String isolamento;

    TIPO_CABO(String material, String isolamento, BigDecimal resistividade) {
        this.material = material;
        this.resistividade = resistividade;
        this.isolamento = isolamento;
    }

    public String getIsolamento() {
        return isolamento;
    }

    public String getMaterial() {
        return material;
    }

    public BigDecimal valorResistividade() {
        return resistividade;
    }
}
