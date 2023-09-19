package br.com.eletrica.domain.model.api.resposta.calculo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DadosUtilizadosParaCalculo {
    private CalculoSecaoCondutor calculoSecaoCondutor = new CalculoSecaoCondutor();
    private CalculoDisjuntor calculoDisjuntor = new CalculoDisjuntor();
    private CalculoEletroduto calculoEletroduto = new CalculoEletroduto();
}
