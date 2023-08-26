package br.com.eletrica.domain.model.api.resposta;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DadosResposta {
    private DadosCircuito circuito = new DadosCircuito();
    private DadosCabeamento cabeamento = new DadosCabeamento();
}
