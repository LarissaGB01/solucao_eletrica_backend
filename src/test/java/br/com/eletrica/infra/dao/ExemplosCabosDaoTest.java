package br.com.eletrica.infra.dao;

import br.com.eletrica.common.exception.ValidacaoException;
import br.com.eletrica.common.util.ConnectionUtil;
import br.com.eletrica.domain.model.infra.DadosConducaoCabos;
import br.com.eletrica.fixtures.ModelFixture;
import br.com.eletrica.infra.entidade.ConducaoCabos;
import br.com.eletrica.infra.mapper.ConducaoCabosMapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ConducaoCabosDaoTest {

    @Mock
    private ConnectionUtil connectionUtil;

    @Mock
    private ConducaoCabosMapper mapper;

    @InjectMocks
    private ConducaoCabosDao conducaoCabosDao;

    @BeforeAll
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @BeforeEach
    public void resetMocks() {
        Mockito.reset(mapper, connectionUtil);
    }
    @Test
    public void testBuscarSecaoMinimaCabo() throws SQLException, ValidacaoException {
        Connection connection = Mockito.mock(Connection.class);
        PreparedStatement statement = Mockito.mock(PreparedStatement.class);
        ResultSet resultSet = Mockito.mock(ResultSet.class);
        DadosConducaoCabos dados = ModelFixture.gerarDadosConducaoCabos();

        Mockito.when(connectionUtil.getConnection()).thenReturn(connection);
        Mockito.when(connection.prepareStatement(anyString())).thenReturn(statement);
        Mockito.when(statement.executeQuery()).thenReturn(resultSet);
        Mockito.when(resultSet.next()).thenReturn(true);
        Mockito.when(resultSet.getString(ConducaoCabos.getNomeColunaMaterial())).thenReturn("Cobre");
        Mockito.when(resultSet.getBigDecimal(ConducaoCabos.getNomeColunaSecaoNominal())).thenReturn(BigDecimal.valueOf(2.5));
        Mockito.when(resultSet.getString(ConducaoCabos.getNomeColunaInstalacao())).thenReturn("Embutida");
        Mockito.when(resultSet.getInt(ConducaoCabos.getNomeColunaCondutoresCarregados())).thenReturn(3);
        Mockito.when(resultSet.getBigDecimal(ConducaoCabos.getNomeColunaCorrenteNominal())).thenReturn(BigDecimal.valueOf(20));
        Mockito.when(resultSet.getString(ConducaoCabos.getNomeColunaIsolacao())).thenReturn("EPR");
        Mockito.when(mapper.toDomain(Mockito.any())).thenReturn(ModelFixture.gerarDadosConducaoCabos());

        assertNotNull(conducaoCabosDao.buscarSecaoMinimaCabo(dados));
        assertDoesNotThrow(() -> conducaoCabosDao.buscarSecaoMinimaCabo(dados));
    }

    @Test
    public void testBuscarSecaoMinimaCaboNaoEncontrado() throws SQLException, ValidacaoException {
        Connection connection = Mockito.mock(Connection.class);
        PreparedStatement statement = Mockito.mock(PreparedStatement.class);
        ResultSet resultSet = Mockito.mock(ResultSet.class);
        DadosConducaoCabos dados = ModelFixture.gerarDadosConducaoCabos();

        Mockito.when(connectionUtil.getConnection()).thenReturn(connection);
        Mockito.when(connection.prepareStatement(anyString())).thenReturn(statement);
        Mockito.when(statement.executeQuery()).thenReturn(resultSet);
        Mockito.when(resultSet.next()).thenReturn(false);
        Mockito.when(mapper.toDomain(Mockito.any())).thenReturn(ModelFixture.gerarDadosConducaoCabos());

        assertNull(conducaoCabosDao.buscarSecaoMinimaCabo(dados));
        assertDoesNotThrow(() -> conducaoCabosDao.buscarSecaoMinimaCabo(dados));
    }

    @Test
    public void testBuscarSecaoMinimaCaboComSQLException() throws SQLException, ValidacaoException {
        Connection connection = Mockito.mock(Connection.class);
        PreparedStatement statement = Mockito.mock(PreparedStatement.class);
        DadosConducaoCabos dados = ModelFixture.gerarDadosConducaoCabos();

        Mockito.when(connectionUtil.getConnection()).thenReturn(connection);
        Mockito.when(connection.prepareStatement(anyString())).thenReturn(statement);
        Mockito.when(statement.executeQuery()).thenThrow(new SQLException());

        assertThrows(ValidacaoException.class, () -> conducaoCabosDao.buscarSecaoMinimaCabo(dados));
    }
}
