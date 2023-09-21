package br.com.eletrica.infra.mapper;

import br.com.eletrica.common.exception.ValidacaoException;
import br.com.eletrica.domain.validacao.geral.ValidarRegrasDeCalculoGeral;
import br.com.eletrica.fixtures.APIFixtures;
import br.com.eletrica.fixtures.InfraFixture;
import br.com.eletrica.fixtures.ModelFixture;
import br.com.eletrica.infra.entidade.ConducaoCabos;
import br.com.eletrica.infra.entidade.FatorTemperatura;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;

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