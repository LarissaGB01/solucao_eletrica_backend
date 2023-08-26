package br.com.eletrica.common.exception;

public class ErroResponse {
    private final Integer codigo;
    private final String mensagem;
    private final String motivo;

    public ErroResponse(Integer codigo, String mensagem, String motivo) {
        this.codigo = codigo;
        this.mensagem = mensagem;
        this.motivo = motivo;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public String getMotivo() {
        return motivo;
    }
}
