package br.com.eletrica.domain.model.builder;

import br.com.eletrica.common.constantes.TIPO_CABO;
import br.com.eletrica.domain.model.api.resposta.DadosCircuito;
import br.com.eletrica.domain.model.infra.DadosConducaoCabos;
import br.com.eletrica.domain.model.infra.DadosFatorTemperatura;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class BuscaFatorTemperaturaBuilder {

    private DadosCircuito dadosCircuito;

    public DadosFatorTemperatura build() {
        var dadosBusca = new DadosFatorTemperatura();
        dadosBusca.setTemperatura(BigDecimal.valueOf(this.dadosCircuito.getTemperaturaAmbiente()));

        var isolamento = this.dadosCircuito.getTipoCabo().equals(TIPO_CABO.ALUMINIO) ?
                TIPO_CABO.PVC.get() :
                TIPO_CABO.EPR.get();
        dadosBusca.setIsolacao(isolamento);

        return dadosBusca;
    }

    public BuscaFatorTemperaturaBuilder setDadosCircuito(DadosCircuito dadosCircuito) {
        this.dadosCircuito = dadosCircuito;
        return this;
    }
}
