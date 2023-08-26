package br.com.eletrica;

import br.com.eletrica.common.exception.ValidacaoException;
import br.com.eletrica.domain.model.api.requisicao.DadosEntrada;
import br.com.eletrica.domain.useCases.CalcularDiametroCabosUseCase;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.math.BigDecimal;

public class Main {

//    public static void main(String[] args) throws JsonProcessingException, ValidacaoException {
//        DadosEntrada entrada = new DadosEntrada();
//        entrada.setUtilizacaoCircuito("TOMADA");
//        entrada.setTipoCircuito("DISTRIBUICAO");
//        entrada.setFasesVoltagem("TRIFASICO");
//        entrada.setVoltagem(380);
//        entrada.setMetodoInstalacao("C");
//        entrada.setTipoCabo("EPR");
//        entrada.setPotenciaAtiva(BigDecimal.valueOf(12000));
//        entrada.setPotenciaAparente(BigDecimal.ZERO);
//        entrada.setFatorDePotencia(BigDecimal.valueOf(0.8));
//        entrada.setTemperaturaAmbiente(30);
//        entrada.setQuantidadeCircuitosAgrupados(2);
//        entrada.setComprimentoFio(60);
//
//        var saida = CalcularDiametroCabosUseCase.calcular(entrada);
//        ObjectMapper objectMapper = new ObjectMapper();
//        System.out.println(objectMapper.writeValueAsString(saida));
//    }
}

