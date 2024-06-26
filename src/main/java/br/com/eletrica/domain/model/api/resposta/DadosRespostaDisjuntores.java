package br.com.eletrica.domain.model.api.resposta;

import br.com.eletrica.domain.model.api.resposta.calculo.CalculoDisjuntor;
import br.com.eletrica.domain.model.api.resposta.dimensionado.DadosDisjuntor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DadosRespostaDisjuntores {
    private DadosDisjuntor disjuntor = new DadosDisjuntor();
    private CalculoDisjuntor dadosUtilizadosParaCalculo = new CalculoDisjuntor();
}
