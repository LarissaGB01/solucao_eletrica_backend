package br.com.eletrica.infra.mapper;

import br.com.eletrica.domain.model.infra.DadosExemploCondutor;
import br.com.eletrica.infra.entidade.ExemplosCabos;

public class ExemplosCabosMapper {
    public DadosExemploCondutor toDomain(ExemplosCabos dto) {
        var domain = new DadosExemploCondutor();

        domain.setDiametroNominalExterno(dto.getDiametroNominalExterno());
        domain.setDiametroNominalCondutor(dto.getDiametroNominalCondutor());

        return domain;
    }
}
