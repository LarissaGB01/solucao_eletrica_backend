package br.com.eletrica.domain.model.api.resposta;

import br.com.eletrica.domain.model.api.resposta.calculo.CalculoSecaoCondutor;
import br.com.eletrica.domain.model.api.resposta.dimensionado.DadosCabeamento;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DadosRespostaCondutores {
    private DadosCabeamento cabeamento = new DadosCabeamento();
    private CalculoSecaoCondutor dadosUtilizadosParaCalculo = new CalculoSecaoCondutor();
}
