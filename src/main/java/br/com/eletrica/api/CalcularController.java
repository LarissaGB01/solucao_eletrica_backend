package br.com.eletrica.api;

import br.com.eletrica.common.exception.ErroResponse;
import br.com.eletrica.common.exception.ValidacaoException;
import br.com.eletrica.domain.model.api.requisicao.DadosEntrada;
import br.com.eletrica.domain.model.api.requisicao.DadosEntradaDisjuntores;
import br.com.eletrica.domain.model.api.resposta.DadosResposta;
import br.com.eletrica.domain.model.api.resposta.DadosRespostaCondutores;
import br.com.eletrica.domain.model.api.resposta.DadosRespostaDisjuntores;
import br.com.eletrica.domain.useCases.CalcularDiametroCabosUseCase;
import br.com.eletrica.domain.useCases.CalcularDisjuntoresUseCase;
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

    private final CalcularDiametroCabosUseCase useCaseCondutores;
    private final CalcularDisjuntoresUseCase useCaseDisjuntores;

    private static final Logger logger = Logger.getLogger(CalcularController.class.getName());

    public CalcularController(CalcularDiametroCabosUseCase useCaseCondutores, CalcularDisjuntoresUseCase useCaseDisjuntores) {
        this.useCaseCondutores = useCaseCondutores;
        this.useCaseDisjuntores = useCaseDisjuntores;
    }

    @PostMapping("/dimensionar")
    DadosResposta dimensionar(@RequestBody DadosEntrada requisicao) {
        logger.info("NOVA REQUISICAO POST/dimensionar-----------------------------");
        logger.info(requisicao.toString());

        var resposta = new DadosResposta();

        // dimensionamento condutores
        resposta.setCabeamento(useCaseCondutores.calcular(requisicao).getCabeamento());
        resposta.setCalculoSecaoCondutor(useCaseCondutores.calcular(requisicao).getCalculoSecaoCondutor());

        // dimensionamento disjuntores
        resposta.setDisjuntor(useCaseDisjuntores.calcularComCondutores(requisicao).getDisjuntor());
        resposta.setCalculoDisjuntor(useCaseDisjuntores.calcularComCondutores(requisicao).getCalculoDisjuntor());

        // dimensionamento eletrodutos

        return resposta;
    }

    @PostMapping("/dimensionar/condutores")
    DadosRespostaCondutores dimensionarCondutores(@RequestBody DadosEntrada requisicao) {
        logger.info("NOVA REQUISICAO POST/dimensionar/condutores------------------");
        logger.info(requisicao.toString());

        var resposta = new DadosRespostaCondutores();
        resposta.setCabeamento(useCaseCondutores.calcular(requisicao).getCabeamento());
        resposta.setCalculoSecaoCondutor(useCaseCondutores.calcular(requisicao).getCalculoSecaoCondutor());

        return resposta;
    }

    @PostMapping("/dimensionar/disjuntores")
    DadosRespostaDisjuntores dimensionarDisjuntores(@RequestBody DadosEntradaDisjuntores requisicao) {
        logger.info("NOVA REQUISICAO POST/dimensionar/disjuntores-----------------");
        logger.info(requisicao.toString());

        var resposta = new DadosRespostaDisjuntores();
        resposta.setDisjuntor(useCaseDisjuntores.calcularSemCondutores(requisicao).getDisjuntor());
        resposta.setCalculoDisjuntor(useCaseDisjuntores.calcularSemCondutores(requisicao).getCalculoDisjuntor());

        return resposta;
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
