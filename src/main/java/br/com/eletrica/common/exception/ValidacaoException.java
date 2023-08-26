package br.com.eletrica.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ValidacaoException extends RuntimeException {
    private final ErrosSistema erro;
    private final String motivo;

    public ValidacaoException(String motivo, ErrosSistema erro) {
        super(erro.getMensagem());
        this.motivo = motivo;
        this.erro = erro;
    }

    public ErrosSistema getErro() {
        return erro;
    }

    public String getMotivo() {
        return motivo;
    }
}
