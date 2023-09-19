package br.com.eletrica.infra.mapper;

import br.com.eletrica.domain.model.infra.DadosExemploEletroduto;
import br.com.eletrica.infra.entidade.ExemplosEletrodutos;

public class ExemplosEletrodutosMapper {
    public DadosExemploEletroduto toDomain(ExemplosEletrodutos dto) {
        var domain = new DadosExemploEletroduto();

        domain.setDiametroExterno(dto.getDiametroExterno());
        domain.setDiametroInterno(dto.getDiametroInterno());
        domain.setDiametroNominalMilimetros(dto.getDiametroNominalMilimetros());
        domain.setDiametroNominalPolegadas(dto.getDiametroNominalPolegadas());

        return domain;
    }
}
