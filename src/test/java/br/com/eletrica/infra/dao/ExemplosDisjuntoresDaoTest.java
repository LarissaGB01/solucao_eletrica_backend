package br.com.eletrica.infra.dao;

import br.com.eletrica.common.exception.ValidacaoException;
import br.com.eletrica.common.util.ConnectionUtil;
import br.com.eletrica.fixtures.ModelFixture;
import br.com.eletrica.infra.entidade.ExemplosCabos;
import br.com.eletrica.infra.mapper.ExemplosCabosMapper;
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
import static org.mockito.Mockito.anyString;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ExemplosCabosDaoTest {

    @Mock
    private ConnectionUtil connectionUtil;

    @Mock
    private ExemplosCabosMapper mapper;

    @InjectMocks
    private ExemplosCabosDao exemplosCabosDao;

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
        var dados = ModelFixture.gerarDadosBuscaCondutor();

        Mockito.when(connectionUtil.getConnection()).thenReturn(connection);
        Mockito.when(connection.prepareStatement(anyString())).thenReturn(statement);
        Mockito.when(statement.executeQuery()).thenReturn(resultSet);
        Mockito.when(resultSet.next()).thenReturn(true);
        Mockito.when(resultSet.getInt(ExemplosCabos.getNomeColunaCabosCarregados())).thenReturn(3);
        Mockito.when(resultSet.getBigDecimal(ExemplosCabos.getNomeColunaSecaoNominal())).thenReturn(BigDecimal.valueOf(2.5));
        Mockito.when(resultSet.getBigDecimal(ExemplosCabos.getNomeColunaDiametroNominalExterno())).thenReturn(BigDecimal.valueOf(2.5));
        Mockito.when(resultSet.getBigDecimal(ExemplosCabos.getNomeColunaDiametroNominalCondutor())).thenReturn(BigDecimal.valueOf(2.5));
        Mockito.when(mapper.toDomain(Mockito.any())).thenReturn(ModelFixture.gerarExemploCabeamento());

        assertNotNull(exemplosCabosDao.buscarExemploCabeamento(dados));
        assertDoesNotThrow(() -> exemplosCabosDao.buscarExemploCabeamento(dados));
    }

    @Test
    public void testBuscarSecaoMinimaCaboNaoEncontrado() throws SQLException, ValidacaoException {
        Connection connection = Mockito.mock(Connection.class);
        PreparedStatement statement = Mockito.mock(PreparedStatement.class);
        ResultSet resultSet = Mockito.mock(ResultSet.class);
        var dados = ModelFixture.gerarDadosBuscaCondutor();

        Mockito.when(connectionUtil.getConnection()).thenReturn(connection);
        Mockito.when(connection.prepareStatement(anyString())).thenReturn(statement);
        Mockito.when(statement.executeQuery()).thenReturn(resultSet);
        Mockito.when(resultSet.next()).thenReturn(false);
        Mockito.when(mapper.toDomain(Mockito.any())).thenReturn(ModelFixture.gerarExemploCabeamento());

        assertNull(exemplosCabosDao.buscarExemploCabeamento(dados));
        assertDoesNotThrow(() -> exemplosCabosDao.buscarExemploCabeamento(dados));
    }

    @Test
    public void testBuscarSecaoMinimaCaboComSQLException() throws SQLException, ValidacaoException {
        Connection connection = Mockito.mock(Connection.class);
        PreparedStatement statement = Mockito.mock(PreparedStatement.class);
        var dados = ModelFixture.gerarDadosBuscaCondutor();

        Mockito.when(connectionUtil.getConnection()).thenReturn(connection);
        Mockito.when(connection.prepareStatement(anyString())).thenReturn(statement);
        Mockito.when(statement.executeQuery()).thenThrow(new SQLException());

        assertThrows(ValidacaoException.class, () -> exemplosCabosDao.buscarExemploCabeamento(dados));
    }
}
