package br.com.eletrica.infra.mapper;

import br.com.eletrica.domain.model.infra.DadosExemploDisjuntor;
import br.com.eletrica.infra.entidade.ExemplosDisjuntores;

public class ExemplosDisjuntoresMapper {
    public DadosExemploDisjuntor toDomain(ExemplosDisjuntores dto) {
        var domain = new DadosExemploDisjuntor();

        domain.setCorrenteNominal(dto.getCorrenteNominal());
        domain.setNomeDisjuntor(dto.getNomeDisjuntor());

        return domain;
    }
}
