package br.com.eletrica.domain.model.api.resposta.dimensionado;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DadosDisjuntor {
    private Integer correnteNominalDisjuntorRecomendado;
    private String nomeDisjuntorRecomendado;
}
