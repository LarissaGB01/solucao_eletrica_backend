package br.com.eletrica.domain.services;

import br.com.eletrica.common.constantes.FASES_VOLTAGEM;
import br.com.eletrica.common.exception.ErrosSistema;
import br.com.eletrica.common.exception.ValidacaoException;
import br.com.eletrica.domain.model.api.resposta.DadosCircuito;
import br.com.eletrica.domain.model.infra.DadosFatorTemperatura;
import br.com.eletrica.infra.repositorio.RepositorioNBR;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class CalcularCorrenteService {

    private final RepositorioNBR repositorioNBR;

    @Autowired
    public CalcularCorrenteService(RepositorioNBR repositorioNBR) {
        this.repositorioNBR = repositorioNBR;
    }

    public BigDecimal calcularCorrenteProjeto(DadosCircuito circuito) {

        // Calcular corrente do circuito
        var divisorCorrenteCircuito = BigDecimal.valueOf(circuito.getVoltagem());
        if (circuito.getFasesVoltagem().equals(FASES_VOLTAGEM.TRIFASICO)) {
            divisorCorrenteCircuito = BigDecimal.valueOf(Math.sqrt(3) * circuito.getVoltagem());
        }
        var correnteCircuito = circuito.getPotenciaAparente().divide(divisorCorrenteCircuito, RoundingMode.HALF_EVEN);

        // Calcular fator de agrupamento
        var fatorAgrupamento = 1 / Math.sqrt(circuito.getQuantidadeCircuitosAgrupados());

        // Buscar fator de temperatura
        var fatorTemperatura = repositorioNBR.buscarFatorTemperatura(new DadosFatorTemperatura(circuito));
        if (fatorTemperatura == null) {
            throw new ValidacaoException("Tente informar outros dados para o tipo do cabo e temperatura ambiente.",
                    ErrosSistema.REGISTRO_TEMPERATURA_NAO_ENCONTRADO);
        }

        // Calcular corrente de projeto
        BigDecimal divisorCorrenteProjeto = fatorTemperatura.multiply(BigDecimal.valueOf(fatorAgrupamento));
        return correnteCircuito.divide(divisorCorrenteProjeto, RoundingMode.DOWN);
    }
}
