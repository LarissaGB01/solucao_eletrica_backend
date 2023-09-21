package br.com.eletrica.domain.services;

import br.com.eletrica.common.constantes.FASES_VOLTAGEM;
import br.com.eletrica.domain.model.api.resposta.calculo.CalculoDiametroMinimoCabo;
import br.com.eletrica.domain.model.DadosCircuito;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class CalcularDiametroCaboService {

    public CalculoDiametroMinimoCabo calcular(BigDecimal resistividade, DadosCircuito circuito) {
        var calculoDiametroMinimoCabo = new CalculoDiametroMinimoCabo();
        calculoDiametroMinimoCabo.setTipoCabo(circuito.getTipoCabo().getMaterial());
        calculoDiametroMinimoCabo.setResistividadeCabo(resistividade);
        calculoDiametroMinimoCabo.setComprimentoFio(circuito.getComprimentoFio());
        calculoDiametroMinimoCabo.setCorrenteProjeto(circuito.getCorrenteProjeto());
        calculoDiametroMinimoCabo.setTipoCircuito(circuito.getTipoCircuito().get());
        calculoDiametroMinimoCabo.setValorVariacaoTensao(circuito.getTipoCircuito().getValorVariacaoTensao());
        calculoDiametroMinimoCabo.setVoltagem(circuito.getVoltagem());
        calculoDiametroMinimoCabo.setUtilizacaoCircuito(circuito.getUtilizacaoCircuito().get());
        calculoDiametroMinimoCabo.setMinimoDiametroCabo(circuito.getUtilizacaoCircuito().getMinimoDiametroCabo());
        calculoDiametroMinimoCabo.setMetodoInstalacao(circuito.getMetodoInstalacao().get());
        calculoDiametroMinimoCabo.setFasesVoltagem(circuito.getFasesVoltagem().get());
        calculoDiametroMinimoCabo.setCabosCarregados(circuito.getFasesVoltagem().getCabosCarregados());
        calculoDiametroMinimoCabo.setMaterialCabo(circuito.getTipoCabo().getMaterial());
        calculoDiametroMinimoCabo.setIsolamentoCabo(circuito.getTipoCabo().getIsolamento());

        var fatorCorrecaoTrifasico = BigDecimal.valueOf(200);
        if (circuito.getFasesVoltagem().equals(FASES_VOLTAGEM.TRIFASICO)) {
            calculoDiametroMinimoCabo.setIndicadorCircuitoTrifasico(true);
            fatorCorrecaoTrifasico = BigDecimal.valueOf(100 * Math.sqrt(3));
        } else {
            calculoDiametroMinimoCabo.setIndicadorCircuitoTrifasico(false);
        }

        var numeradorCalculo = fatorCorrecaoTrifasico
                .multiply(resistividade)
                .multiply(BigDecimal.valueOf(circuito.getComprimentoFio()))
                .multiply(circuito.getCorrenteProjeto());

        var denominadorCalculo = BigDecimal.valueOf(circuito.getTipoCircuito().getValorVariacaoTensao())
                .multiply(BigDecimal.valueOf(circuito.getVoltagem()));

        var diametroCalculado = numeradorCalculo.divide(denominadorCalculo, RoundingMode.DOWN);
        calculoDiametroMinimoCabo.setDiametroCalculado(diametroCalculado);

        // Verificar finalidade do circuito para valor mínimo
        var secaoMinima = circuito.getUtilizacaoCircuito().getMinimoDiametroCabo();
        calculoDiametroMinimoCabo.setMinimoDiametroCabo(circuito.getUtilizacaoCircuito().getMinimoDiametroCabo());
        calculoDiametroMinimoCabo.setIndicadorMinimoDiametroUtilizado(false);

        if (diametroCalculado.compareTo(secaoMinima) < 0) {
            calculoDiametroMinimoCabo.setIndicadorMinimoDiametroUtilizado(true);
        }

        return calculoDiametroMinimoCabo;
    }
}
