package br.com.eletrica.infra.mapper;

import br.com.eletrica.common.exception.ValidacaoException;
import br.com.eletrica.fixtures.InfraFixture;
import br.com.eletrica.infra.entidade.ExemplosCabos;
import br.com.eletrica.infra.entidade.ExemplosDisjuntores;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ExemplosDisjuntoresMapperTest {

    @Test
    public void deveMapearComSucesso() throws ValidacaoException {
        var mapper = new ExemplosDisjuntoresMapper();
        var dados = InfraFixture.gerarExemplosDisjuntores();
        assertNotNull(mapper.toDomain(dados));
        assertNotNull(mapper.toDomain(new ExemplosDisjuntores()));
    }
}