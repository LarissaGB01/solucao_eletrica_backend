package br.com.eletrica.domain.model.api.resposta;

import br.com.eletrica.domain.model.api.resposta.calculo.CalculoEletroduto;
import br.com.eletrica.domain.model.api.resposta.dimensionado.DadosEletroduto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DadosRespostaEletroduto {
    private DadosEletroduto eletroduto = new DadosEletroduto();
    private CalculoEletroduto dadosUtilizadosParaCalculo = new CalculoEletroduto();
}
