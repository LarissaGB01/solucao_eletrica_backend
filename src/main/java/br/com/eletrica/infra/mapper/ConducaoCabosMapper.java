package br.com.eletrica.infra.mapper;

import br.com.eletrica.domain.model.infra.DadosConducaoCabos;
import br.com.eletrica.infra.entidade.ConducaoCabos;

public class ConducaoCabosMapper {
    public DadosConducaoCabos toDomain(ConducaoCabos dto) {
        var domain = new DadosConducaoCabos();

        domain.setMaterial(dto.getMaterial());
        domain.setSecaoNominal(dto.getSecaoNominal() != null ? dto.getSecaoNominal() : null);
        domain.setInstalacao(dto.getInstalacao());
        domain.setCondutoresCarregados(dto.getCondutoresCarregados());
        domain.setCorrenteNominal(dto.getCorrenteNominal() != null ? dto.getCorrenteNominal() : null);
        domain.setIsolamento(dto.getIsolamento());

        return domain;
    }
}
