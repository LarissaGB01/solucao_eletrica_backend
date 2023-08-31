package br.com.eletrica.api;

import br.com.eletrica.common.exception.ErroResponse;
import br.com.eletrica.common.exception.ValidacaoException;
import br.com.eletrica.domain.model.api.requisicao.DadosEntrada;
import br.com.eletrica.domain.model.api.resposta.DadosResposta;
import br.com.eletrica.domain.useCases.CalcularDiametroCabosUseCase;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
public class CalcularController {

    private final CalcularDiametroCabosUseCase useCase;

    private static final Logger logger = Logger.getLogger(CalcularController.class.getName());

    public CalcularController(CalcularDiametroCabosUseCase useCase) {
        this.useCase = useCase;
    }

    @PostMapping("/dimensionar")
    DadosResposta dimensionar(@RequestBody DadosEntrada requisicao) {
        logger.info("NOVA REQUISICAO POST/dimensionar-----------------------------");
        logger.info(requisicao.toString());
        return useCase.calcular(requisicao);
    }

    @ExceptionHandler(ValidacaoException.class)
    public ResponseEntity<ErroResponse> formatarExcecao(ValidacaoException ex) throws JsonProcessingException {
        ErroResponse erroResponse = new ErroResponse(
                ex.getErro().getCodigo(),
                ex.getErro().getMensagem(),
                ex.getMotivo());
        ObjectMapper objectMapper = new ObjectMapper();
        logger.severe(objectMapper.writeValueAsString(erroResponse));
        return ResponseEntity.status(ex.getErro().getHttpStatus()).body(erroResponse);
    }
}
