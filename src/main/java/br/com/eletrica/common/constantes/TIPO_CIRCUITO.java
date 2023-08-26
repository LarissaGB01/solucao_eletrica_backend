package br.com.eletrica.common.constantes;

public enum TIPO_CIRCUITO {
    DISTRIBUICAO("DISTRIBUICAO", 2),
    TERMINAL("TERMINAL", 4);

    private final String descricao;
    private final Integer variacaoTensaoPercentual;

    private TIPO_CIRCUITO(String descricao, Integer variacaoTensaoPercentual) {
        this.variacaoTensaoPercentual = variacaoTensaoPercentual;
        this.descricao = descricao;
    }

    public String get() {
        return descricao;
    }

    public Integer getValorVariacaoTensao() {
        return variacaoTensaoPercentual;
    }
}
