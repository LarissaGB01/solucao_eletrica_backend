package br.com.eletrica.api;
//
//import br.com.eletrica.common.exception.ErroResponse;
//import br.com.eletrica.common.exception.ValidacaoException;
//import br.com.eletrica.domain.model.api.requisicao.DadosEntrada;
//import br.com.eletrica.domain.model.api.resposta.DadosResposta;
//import br.com.eletrica.domain.useCases.CalcularDiametroCabosUseCase;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import br.com.eletrica.common.exception.ErrosSistema;
//import br.com.eletrica.common.exception.ValidacaoException;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.validation.Valid;
//import java.util.Optional;
//
//@RestController
//@RequestMapping("/api")
public class CalcularController {
//    @RequestMapping(value = "/dimensionar", method =  RequestMethod.POST)
//    public ResponseEntity<DadosResposta> Post(@Valid @RequestBody DadosEntrada requisicao) throws ValidacaoException {
//        CalcularDiametroCabosUseCase useCase = new CalcularDiametroCabosUseCase();
//        var resposta = useCase.calcular(requisicao);
//        return new ResponseEntity<DadosResposta>(resposta, HttpStatus.OK);
//    }
//
//    @ExceptionHandler(ValidacaoException.class)
//    public ResponseEntity<ErroResponse> handleValidacaoException(ValidacaoException ex) {
//        ErroResponse erroResponse = new ErroResponse(
//                ex.getErro().getCodigo(),
//                ex.getErro().getMensagem(),
//                ex.getMotivo());
//
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erroResponse);
//    }
//
}

