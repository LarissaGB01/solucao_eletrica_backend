package br.com.eletrica.domain.model.infra;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DadosExemploDisjuntor {
    private int correnteNominal;
    private String nomeDisjuntor;
}
