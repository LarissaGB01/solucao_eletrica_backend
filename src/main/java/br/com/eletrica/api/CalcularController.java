package br.com.eletrica.api;

import br.com.eletrica.common.exception.ErroResponse;
import br.com.eletrica.common.exception.ValidacaoException;
import br.com.eletrica.domain.model.api.requisicao.DadosEntrada;
import br.com.eletrica.domain.model.api.resposta.DadosResposta;
import br.com.eletrica.domain.useCases.CalcularDiametroCabosUseCase;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.logging.Logger;

@RestController
public class CalcularController {

    private final CalcularDiametroCabosUseCase useCase;

    public CalcularController(CalcularDiametroCabosUseCase useCase) {
        this.useCase = useCase;
    }

    @PostMapping("/dimensionar")
    DadosResposta dimensionar(@RequestBody DadosEntrada requisicao) {
        Logger.getLogger("NOVA REQUISIÇÃO POST");
        return useCase.calcular(requisicao);
    }

    @ExceptionHandler(ValidacaoException.class)
    public ResponseEntity<ErroResponse> handleValidacaoException(ValidacaoException ex) {
        ErroResponse erroResponse = new ErroResponse(
                ex.getErro().getCodigo(),
                ex.getErro().getMensagem(),
                ex.getMotivo());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erroResponse);
    }

}

