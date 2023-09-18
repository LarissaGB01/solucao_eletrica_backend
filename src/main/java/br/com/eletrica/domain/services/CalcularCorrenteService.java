package br.com.eletrica.domain.services;

import br.com.eletrica.common.constantes.FASES_VOLTAGEM;
import br.com.eletrica.common.exception.ErrosSistema;
import br.com.eletrica.common.exception.ValidacaoException;
import br.com.eletrica.domain.model.api.resposta.calculo.CalculoCorrenteProjeto;
import br.com.eletrica.domain.model.DadosCircuito;
import br.com.eletrica.domain.model.infra.DadosBuscaFatorTemperatura;
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

    public CalculoCorrenteProjeto calcularCorrenteProjeto(DadosCircuito circuito) {
        var dadosDeCalculo = new CalculoCorrenteProjeto();
        dadosDeCalculo.setVoltagem(circuito.getVoltagem());
        dadosDeCalculo.setPotenciaAparente(circuito.getPotenciaAparente());
        dadosDeCalculo.setQuantidadeCircuitosAgrupados(circuito.getQuantidadeCircuitosAgrupados());
        dadosDeCalculo.setTemperaturaAmbiente(circuito.getTemperaturaAmbiente());
        dadosDeCalculo.setIsolacaoCabo(circuito.getTipoCabo().getIsolamento());

        // Calcular corrente do circuito
        var divisorCorrenteCircuito = BigDecimal.valueOf(circuito.getVoltagem());
        if (circuito.getFasesVoltagem().equals(FASES_VOLTAGEM.TRIFASICO)) {
            dadosDeCalculo.setIndicadorCircuitoTrifasico(true);
            divisorCorrenteCircuito = BigDecimal.valueOf(Math.sqrt(3) * circuito.getVoltagem());
        } else {
            dadosDeCalculo.setIndicadorCircuitoTrifasico(false);
        }

        var correnteCircuito = circuito.getPotenciaAparente().divide(divisorCorrenteCircuito, RoundingMode.HALF_EVEN);
        dadosDeCalculo.setCorrenteCircuito(correnteCircuito);

        // Calcular fator de agrupamento
        var fatorAgrupamento = 1 / Math.sqrt(circuito.getQuantidadeCircuitosAgrupados());
        dadosDeCalculo.setFatorAgrupamento(fatorAgrupamento);

        // Buscar fator de temperatura
        var fatorTemperatura = repositorioNBR.buscarFatorTemperatura(new DadosBuscaFatorTemperatura(circuito));
        if (fatorTemperatura == null) {
            throw new ValidacaoException("Tente informar outros dados para o tipo do cabo e temperatura ambiente.",
                    ErrosSistema.REGISTRO_TEMPERATURA_NAO_ENCONTRADO);
        }
        dadosDeCalculo.setFatorTemperatura(fatorTemperatura);

        // Calcular corrente de projeto
        BigDecimal divisorCorrenteProjeto = fatorTemperatura.multiply(BigDecimal.valueOf(fatorAgrupamento));
        dadosDeCalculo.setCorrenteProjeto(correnteCircuito.divide(divisorCorrenteProjeto, RoundingMode.DOWN));

        return dadosDeCalculo;
    }
}
