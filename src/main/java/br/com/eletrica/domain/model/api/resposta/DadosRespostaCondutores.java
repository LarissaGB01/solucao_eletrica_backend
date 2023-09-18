package br.com.eletrica.domain.model.api.resposta;

import br.com.eletrica.domain.model.api.resposta.calculo.CalculoDisjuntor;
import br.com.eletrica.domain.model.api.resposta.calculo.CalculoSecaoCondutor;
import br.com.eletrica.domain.model.api.resposta.dimensionado.DadosCabeamento;
import br.com.eletrica.domain.model.api.resposta.dimensionado.DadosDisjuntor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DadosRespostaCondutores {
    private DadosCabeamento cabeamento = new DadosCabeamento();
    private CalculoSecaoCondutor calculoSecaoCondutor = new CalculoSecaoCondutor();
}
