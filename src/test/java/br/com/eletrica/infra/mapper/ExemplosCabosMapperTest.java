package br.com.eletrica.infra.mapper;

import br.com.eletrica.common.exception.ValidacaoException;
import br.com.eletrica.fixtures.InfraFixture;
import br.com.eletrica.infra.entidade.ConducaoCabos;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ConducaoCabosMapperTest {

    @Test
    public void deveMapearComSucesso() throws ValidacaoException {
        var mapper = new ConducaoCabosMapper();
        var dados = InfraFixture.gerarConducaoCabos();
        assertNotNull(mapper.toDomain(dados));
        assertNotNull(mapper.toDomain(new ConducaoCabos()));
    }
}