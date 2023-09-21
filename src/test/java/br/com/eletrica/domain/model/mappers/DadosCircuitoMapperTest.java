package br.com.eletrica.domain.model.mappers;

import br.com.eletrica.common.exception.ValidacaoException;
import br.com.eletrica.fixtures.APIFixtures;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class DadosCircuitoMapperTest {
    @Test
    public void deveMapearComSucesso() throws ValidacaoException {
        var mapper = new DadosCircuitoMapper();
        var dados = APIFixtures.gerarRequisicaoGeral();
        assertNotNull(mapper.toDomain(dados));
    }
}