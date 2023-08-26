package br.com.eletrica.domain.model.builder;

import br.com.eletrica.common.constantes.TIPO_CABO;
import br.com.eletrica.domain.model.api.resposta.DadosCircuito;
import br.com.eletrica.domain.model.infra.DadosConducaoCabos;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class BuscaSecaoMinimaBuilder {

    private DadosCircuito dadosCircuito;
    private BigDecimal secaoCalculada;

    public DadosConducaoCabos build() {
        var dadosConducao = new DadosConducaoCabos();
        dadosConducao.setInstalacao(this.dadosCircuito.getMetodoInstalacao().get());
        dadosConducao.setSecaoNominal(this.secaoCalculada);
        dadosConducao.setCorrenteNominal(this.dadosCircuito.getCorrenteProjeto());
        dadosConducao.setCondutoresCarregados(this.dadosCircuito.getQuantidadeCircuitosAgrupados());

        var material = this.dadosCircuito.getTipoCabo().equals(TIPO_CABO.ALUMINIO) ?
                TIPO_CABO.ALUMINIO.get() :
                TIPO_CABO.COBRE.get();
        dadosConducao.setMaterial(material);

        var isolamento = this.dadosCircuito.getTipoCabo().equals(TIPO_CABO.ALUMINIO) ?
                TIPO_CABO.PVC.get() :
                TIPO_CABO.EPR.get();
        dadosConducao.setIsolamento(isolamento);

        return dadosConducao;
    }

    public BuscaSecaoMinimaBuilder setDadosCircuito(DadosCircuito dadosCircuito) {
        this.dadosCircuito = dadosCircuito;
        return this;
    }

    public BuscaSecaoMinimaBuilder setSecaoCalculada(BigDecimal secaoCalculada) {
        this.secaoCalculada = secaoCalculada;
        return this;
    }
}
