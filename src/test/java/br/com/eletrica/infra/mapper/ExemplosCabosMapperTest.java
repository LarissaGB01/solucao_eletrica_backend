package br.com.eletrica.infra.mapper;

import br.com.eletrica.common.exception.ValidacaoException;
import br.com.eletrica.fixtures.InfraFixture;
import br.com.eletrica.infra.entidade.ConducaoCabos;
import br.com.eletrica.infra.entidade.ExemplosCabos;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ExemplosCabosMapperTest {

    @Test
    public void deveMapearComSucesso() throws ValidacaoException {
        var mapper = new ExemplosCabosMapper();
        var dados = InfraFixture.gerarExemplosCabos();
        assertNotNull(mapper.toDomain(dados));
        assertNotNull(mapper.toDomain(new ExemplosCabos()));
    }
}