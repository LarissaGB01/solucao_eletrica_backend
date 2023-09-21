package br.com.eletrica.infra.repositorio;

import br.com.eletrica.common.exception.ValidacaoException;
import br.com.eletrica.common.util.ConnectionUtil;
import br.com.eletrica.domain.model.infra.DadosConducaoCabos;
import br.com.eletrica.fixtures.ModelFixture;
import br.com.eletrica.infra.dao.*;
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
import static org.mockito.ArgumentMatchers.anyString;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class RepositorioNBRTest {
    @Mock
    private FatorTemperaturaDao fatorTemperaturaDao;

    @Mock
    private ConducaoCabosDao conducaoCabosDao;

    @Mock
    private ExemplosCabosDao exemplosCabosDao;

    @Mock
    private ExemplosDisjuntoresDao exemplosDisjuntoresDao;

    @Mock
    private ExemplosEletrodutosDao exemplosEletrodutosDao;

    @InjectMocks
    private RepositorioNBR repositorio;

    @BeforeAll
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @BeforeEach
    public void resetMocks() {
        Mockito.reset(fatorTemperaturaDao, conducaoCabosDao, exemplosCabosDao, exemplosDisjuntoresDao, exemplosEletrodutosDao);
    }

    @Test
    public void testaBuscarFatorTemperatura() {
        Mockito.when(fatorTemperaturaDao.buscarFatorCorrecaoTemperatura(Mockito.any())).thenReturn(BigDecimal.ONE);
        assertDoesNotThrow(() -> repositorio.buscarFatorTemperatura(ModelFixture.gerarDadosBuscaFatorTemperatura()));
    }

    @Test
    public void testaBuscarSecaoMinimaCabo() {
        Mockito.when(conducaoCabosDao.buscarSecaoMinimaCabo(Mockito.any())).thenReturn(ModelFixture.gerarDadosConducaoCabos());
        assertDoesNotThrow(() -> repositorio.buscarSecaoMinimaCabo(ModelFixture.gerarDadosConducaoCabos()));
    }

    @Test
    public void testaBuscarExemploCabeamento() {
        Mockito.when(exemplosCabosDao.buscarExemploCabeamento(Mockito.any())).thenReturn(ModelFixture.gerarExemploCabeamento());
        assertDoesNotThrow(() -> repositorio.buscarExemploCabeamento(ModelFixture.gerarDadosBuscaCondutor()));
    }

    @Test
    public void testaBuscarExemploDisjuntor() {
        Mockito.when(exemplosDisjuntoresDao.buscarExemploDisjuntores(Mockito.any())).thenReturn(ModelFixture.gerarExemploDisjuntor());
        assertDoesNotThrow(() -> repositorio.buscarExemploDisjuntor(ModelFixture.gerarDadosBuscaDisjuntor()));
    }

    @Test
    public void testaBuscarExemploEletroduto() {
        Mockito.when(exemplosEletrodutosDao.buscarExemploEletrodutos(Mockito.any())).thenReturn(ModelFixture.gerarExemploEletroduto());
        assertDoesNotThrow(() -> repositorio.buscarExemploEletroduto(BigDecimal.ONE));
    }
}