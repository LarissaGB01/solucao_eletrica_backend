package br.com.eletrica.domain.services;

import br.com.eletrica.common.constantes.FASES_VOLTAGEM;
import br.com.eletrica.domain.model.api.resposta.DadosCircuito;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class CalcularDiametroCaboService {

    public static BigDecimal calcular(BigDecimal resistividade, DadosCircuito circuito) {
        var fatorCorrecaoTrifasico = BigDecimal.valueOf(200);
        if (circuito.getFasesVoltagem().equals(FASES_VOLTAGEM.TRIFASICO)) {
            fatorCorrecaoTrifasico = BigDecimal.valueOf(100 * Math.sqrt(3));
        }

        var numeradorCalculo = fatorCorrecaoTrifasico
                .multiply(resistividade)
                .multiply(BigDecimal.valueOf(circuito.getComprimentoFio()))
                .multiply(circuito.getCorrenteProjeto());

        var denominadorCalculo = BigDecimal.valueOf(circuito.getTipoCircuito().getValorVariacaoTensao())
                .multiply(BigDecimal.valueOf(circuito.getVoltagem()));

        return numeradorCalculo.divide(denominadorCalculo, RoundingMode.DOWN);
    }
}
