package br.com.eletrica.common.constantes;

public enum FASES_VOLTAGEM {
    MONOFASICO("MONOFASICO", 2),
    BIFASICO("BIFASICO", 2),
    TRIFASICO("TRIFASICO", 3);

    private final String descricao;
    private final Integer quantidadeCabosCarregados;

    private FASES_VOLTAGEM(String descricao, Integer quantidadeCabosCarregados) {
        this.descricao = descricao;
        this.quantidadeCabosCarregados = quantidadeCabosCarregados;
    }

    public String get() {
        return descricao;
    }

    public Integer getCabosCarregados() {
        return quantidadeCabosCarregados;
    }
}
