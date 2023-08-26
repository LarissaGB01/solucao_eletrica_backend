package br.com.eletrica.common.constantes;

public enum METODO_INSTALACAO {
    A1("A1"),
    A2("A2"),
    B1("B1"),
    B2("B2"),
    C("C"),
    D("D");

    private final String descricao;

    private METODO_INSTALACAO(String descricao) {
        this.descricao = descricao;
    }

    public String get() {
        return descricao;
    }
}
