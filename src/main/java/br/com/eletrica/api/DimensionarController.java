package br.com.eletrica.api;

import br.com.eletrica.common.exception.ErroResponse;
import br.com.eletrica.common.exception.ValidacaoException;
import br.com.eletrica.domain.model.api.requisicao.DadosEntrada;
import br.com.eletrica.domain.model.api.requisicao.DadosEntradaDisjuntores;
import br.com.eletrica.domain.model.api.requisicao.DadosEntradaEletrodutos;
import br.com.eletrica.domain.model.api.resposta.DadosResposta;
import br.com.eletrica.domain.model.api.resposta.DadosRespostaCondutores;
import br.com.eletrica.domain.model.api.resposta.DadosRespostaDisjuntores;
import br.com.eletrica.domain.model.api.resposta.DadosRespostaEletroduto;
import br.com.eletrica.domain.useCases.CalcularDiametroCabosUseCase;
import br.com.eletrica.domain.useCases.CalcularDisjuntoresUseCase;
import br.com.eletrica.domain.useCases.CalcularEletrodutosUseCase;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Duration;
import java.time.Instant;
import java.util.logging.Logger;

@RestController
public class DimensionarController {

    private final CalcularDiametroCabosUseCase useCaseCondutores;
    private final CalcularDisjuntoresUseCase useCaseDisjuntores;
    private final CalcularEletrodutosUseCase useCaseEletrodutos;

    private static final Logger logger = Logger.getLogger(DimensionarController.class.getName());

    public DimensionarController(CalcularDiametroCabosUseCase useCaseCondutores, CalcularDisjuntoresUseCase useCaseDisjuntores, CalcularEletrodutosUseCase useCaseEletrodutos) {
        this.useCaseCondutores = useCaseCondutores;
        this.useCaseDisjuntores = useCaseDisjuntores;
        this.useCaseEletrodutos = useCaseEletrodutos;
    }

    @RequestMapping(value = "/dimensionar", method =  RequestMethod.POST, produces="application/json", consumes="application/json")
    @ApiOperation(value = "Dimensionar condutores, eletrodutos e disjuntores")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Sucesso"),
            @ApiResponse(code = 400, message = "Campos de requisicao informados nao sao aceitos"),
            @ApiResponse(code = 422, message = "Campos de requisicao informados nao podem ser processados"),
            @ApiResponse(code = 500, message = "Erro no sistema"),
    })
    DadosResposta dimensionar(@RequestBody DadosEntrada requisicao) {
        var inicio = Instant.now();
        logger.info("NOVA REQUISICAO POST/dimensionar-----------------------------");
        logger.info(requisicao.toString());

        var resposta = new DadosResposta();

        // dimensionamento condutores
        var dadosCondutores = useCaseCondutores.calcular(requisicao);
        resposta.getDadosDimensionados().setCabeamento(dadosCondutores.getDadosDimensionados().getCabeamento());
        resposta.getDadosUtilizadosParaCalculo().setCalculoSecaoCondutor(dadosCondutores.getDadosUtilizadosParaCalculo().getCalculoSecaoCondutor());

        // dimensionamento disjuntores
        var dadosDisjuntores = useCaseDisjuntores.calcularComCondutores(requisicao);
        resposta.getDadosDimensionados().setDisjuntor(dadosDisjuntores.getDadosDimensionados().getDisjuntor());
        resposta.getDadosUtilizadosParaCalculo().setCalculoDisjuntor(dadosDisjuntores.getDadosUtilizadosParaCalculo().getCalculoDisjuntor());

        // dimensionamento eletrodutos
        var dadosEletrodutos = useCaseEletrodutos.calcularComCondutores(requisicao);
        resposta.getDadosDimensionados().setEletroduto(dadosEletrodutos.getDadosDimensionados().getEletroduto());
        resposta.getDadosUtilizadosParaCalculo().setCalculoEletroduto(dadosEletrodutos.getDadosUtilizadosParaCalculo().getCalculoEletroduto());

        var duration = Duration.between(inicio, Instant.now());
        long tempoDecorrido = duration.toMillis();
        logger.info("Response: 200 SUCESSO (" +  tempoDecorrido + "ms)-----------------");
        return resposta;
    }

    @RequestMapping(value = "/dimensionar/condutores", method =  RequestMethod.POST, produces="application/json", consumes="application/json")
    @ApiOperation(value = "Dimensionar apenas condutores")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Sucesso"),
            @ApiResponse(code = 400, message = "Campos de requisicao informados nao sao aceitos"),
            @ApiResponse(code = 422, message = "Campos de requisicao informados nao podem ser processados"),
            @ApiResponse(code = 500, message = "Erro no sistema"),
    })
    DadosRespostaCondutores dimensionarCondutores(@RequestBody DadosEntrada requisicao) {
        var inicio = Instant.now();
        logger.info("NOVA REQUISICAO POST/dimensionar/condutores------------------");
        logger.info(requisicao.toString());

        var resposta = new DadosRespostaCondutores();
        var dadosCondutores = useCaseCondutores.calcular(requisicao);
        resposta.setCabeamento(dadosCondutores.getDadosDimensionados().getCabeamento());
        resposta.setDadosUtilizadosParaCalculo(dadosCondutores.getDadosUtilizadosParaCalculo().getCalculoSecaoCondutor());

        var duration = Duration.between(inicio, Instant.now());
        long tempoDecorrido = duration.toMillis();
        logger.info("Response: 200 SUCESSO (" +  tempoDecorrido + "ms)-----------------");
        return resposta;
    }

    @RequestMapping(value = "/dimensionar/disjuntores", method =  RequestMethod.POST, produces="application/json", consumes="application/json")
    @ApiOperation(value = "Dimensionar apenas disjuntores")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Sucesso"),
            @ApiResponse(code = 400, message = "Campos de requisicao informados nao sao aceitos"),
            @ApiResponse(code = 422, message = "Campos de requisicao informados nao podem ser processados"),
            @ApiResponse(code = 500, message = "Erro no sistema"),
    })
    DadosRespostaDisjuntores dimensionarDisjuntores(@RequestBody DadosEntradaDisjuntores requisicao) {
        var inicio = Instant.now();
        logger.info("NOVA REQUISICAO POST/dimensionar/disjuntores-----------------");
        logger.info(requisicao.toString());

        var resposta = new DadosRespostaDisjuntores();
        var dadosDisjuntores = useCaseDisjuntores.calcularSemCondutores(requisicao);
        resposta.setDisjuntor(dadosDisjuntores.getDadosDimensionados().getDisjuntor());
        resposta.setDadosUtilizadosParaCalculo(dadosDisjuntores.getDadosUtilizadosParaCalculo().getCalculoDisjuntor());

        var duration = Duration.between(inicio, Instant.now());
        long tempoDecorrido = duration.toMillis();
        logger.info("Response: 200 SUCESSO (" +  tempoDecorrido + "ms)-----------------");
        return resposta;
    }

    @RequestMapping(value = "/dimensionar/eletrodutos", method =  RequestMethod.POST, produces="application/json", consumes="application/json")
    @ApiOperation(value = "Dimensionar apenas eletrodutos")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Sucesso"),
            @ApiResponse(code = 400, message = "Campos de requisicao informados nao sao aceitos"),
            @ApiResponse(code = 422, message = "Campos de requisicao informados nao podem ser processados"),
            @ApiResponse(code = 500, message = "Erro no sistema"),
    })
    DadosRespostaEletroduto dimensionarEletrodutos(@RequestBody DadosEntradaEletrodutos requisicao) {
        var inicio = Instant.now();
        logger.info("NOVA REQUISICAO POST/dimensionar/eletrodutos-----------------");
        logger.info(requisicao.toString());

        var resposta = new DadosRespostaEletroduto();
        var dadosEletrodutos = useCaseEletrodutos.calcularSemCondutores(requisicao);
        resposta.setEletroduto(dadosEletrodutos.getDadosDimensionados().getEletroduto());
        resposta.setDadosUtilizadosParaCalculo(dadosEletrodutos.getDadosUtilizadosParaCalculo().getCalculoEletroduto());

        var duration = Duration.between(inicio, Instant.now());
        long tempoDecorrido = duration.toMillis();
        logger.info("Response: 200 SUCESSO (" +  tempoDecorrido + "ms)-----------------");
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
