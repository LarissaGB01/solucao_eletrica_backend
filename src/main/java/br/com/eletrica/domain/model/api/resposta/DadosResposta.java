package br.com.eletrica.domain.model.api.resposta;

import br.com.eletrica.domain.model.api.resposta.calculo.DadosUtilizadosParaCalculo;
import br.com.eletrica.domain.model.api.resposta.dimensionado.DadosDimensionados;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DadosResposta {
    private DadosDimensionados dadosDimensionados = new DadosDimensionados();
    private DadosUtilizadosParaCalculo dadosUtilizadosParaCalculo = new DadosUtilizadosParaCalculo();
}
