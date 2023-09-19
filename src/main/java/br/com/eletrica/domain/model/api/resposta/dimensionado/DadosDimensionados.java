package br.com.eletrica.domain.model.api.resposta.dimensionado;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DadosDimensionados {
    private DadosCabeamento cabeamento = new DadosCabeamento();
    private DadosDisjuntor disjuntor = new DadosDisjuntor();
    private DadosEletroduto eletroduto = new DadosEletroduto();
}
