package br.com.eletrica.domain.services;

import br.com.eletrica.common.constantes.FASES_VOLTAGEM;
import br.com.eletrica.domain.model.api.resposta.DadosCircuito;
import br.com.eletrica.domain.model.builder.BuscaFatorTemperaturaBuilder;
import br.com.eletrica.domain.model.builder.BuscaSecaoMinimaBuilder;
import br.com.eletrica.domain.model.infra.DadosConducaoCabos;
import br.com.eletrica.infra.repositorio.RepositorioNBR;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.SQLException;

public class CalcularCorrenteService {

    public static BigDecimal calcularCorrenteProjeto(DadosCircuito circuito) {

        var repositorio = new RepositorioNBR();

        // calcular corrente do circuito
        var divisorCorrenteCircuito = BigDecimal.valueOf(circuito.getVoltagem());
        if (circuito.getFasesVoltagem().equals(FASES_VOLTAGEM.TRIFASICO)) {
            divisorCorrenteCircuito = BigDecimal.valueOf(Math.sqrt(3) * circuito.getVoltagem());
        }
        var correnteCircuito = circuito.getPotenciaAparente().divide(divisorCorrenteCircuito, RoundingMode.DOWN);

        // calcular fator de agrupamento
        var fatorAgrupamento = 1 / Math.sqrt(circuito.getQuantidadeCircuitosAgrupados());

        // buscar fator de temperatura
        var dadosBuscaFatorTemperatura = new BuscaFatorTemperaturaBuilder()
                .setDadosCircuito(circuito)
                .build();
        var fatorTemperatura = BigDecimal.ZERO;
        try {
            fatorTemperatura = repositorio.buscarFatorTemperatura(dadosBuscaFatorTemperatura);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        // calcular corrente de projeto
        var divisorCorrenteProjeto = fatorTemperatura.multiply(BigDecimal.valueOf(fatorAgrupamento));
        return correnteCircuito.divide(divisorCorrenteProjeto, RoundingMode.DOWN);
    }
}
