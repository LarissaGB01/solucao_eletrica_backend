package br.com.eletrica.domain.model.api.resposta;

import br.com.eletrica.domain.model.api.resposta.calculo.CalculoSecaoCondutor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DadosResposta {
    private DadosCabeamento cabeamento = new DadosCabeamento();
    private CalculoSecaoCondutor calculoSecaoCondutor = new CalculoSecaoCondutor();
}
