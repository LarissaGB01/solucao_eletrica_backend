package br.com.eletrica.common.config;

import br.com.eletrica.domain.model.mappers.DadosCircuitoMapper;
import br.com.eletrica.infra.mapper.ConducaoCabosMapper;
import br.com.eletrica.infra.mapper.ExemplosCabosMapper;
import br.com.eletrica.infra.mapper.ExemplosDisjuntoresMapper;
import br.com.eletrica.infra.mapper.ExemplosEletrodutosMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@Configuration
@Import(ConfiguracaoSpring.class)
public class ConfiguracaoSpringTest {

    @Mock
    private DadosCircuitoMapper dadosCircuitoMapper;

    @Mock
    private ConducaoCabosMapper conducaoCabosMapper;

    @Mock
    private ExemplosCabosMapper exemplosCabosMapper;

    @Mock
    private ExemplosDisjuntoresMapper exemplosDisjuntoresMapper;

    @Mock
    private ExemplosEletrodutosMapper exemplosEletrodutosMapper;

    @Mock
    private ObjectMapper objectMapper;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testaObjectMapperBean() {
        ConfiguracaoSpring configuracaoSpring = new ConfiguracaoSpring();
        ObjectMapper objectMapper = configuracaoSpring.objectMapper();
        assertNotNull(objectMapper);
    }

    @Test
    public void testaDadosCircuitoMapperBean() {
        ConfiguracaoSpring configuracaoSpring = new ConfiguracaoSpring();
        DadosCircuitoMapper dadosCircuitoMapper = configuracaoSpring.dadosCircuitoMapper();
        assertNotNull(dadosCircuitoMapper);
    }

    @Test
    public void testaConducaoCabosMapperBean() {
        ConfiguracaoSpring configuracaoSpring = new ConfiguracaoSpring();
        ConducaoCabosMapper conducaoCabosMapper = configuracaoSpring.conducaoCabosMapper();
        assertNotNull(conducaoCabosMapper);
    }

    @Test
    public void testaExemplosCabosMapperBean() {
        ConfiguracaoSpring configuracaoSpring = new ConfiguracaoSpring();
        ExemplosCabosMapper exemplosCabosMapper = configuracaoSpring.exemplosCabosMapper();
        assertNotNull(exemplosCabosMapper);
    }

    @Test
    public void testaExemplosDisjuntoresMapperBean() {
        ConfiguracaoSpring configuracaoSpring = new ConfiguracaoSpring();
        ExemplosDisjuntoresMapper exemplosDisjuntoresMapper = configuracaoSpring.exemplosDisjuntoresMapper();
        assertNotNull(exemplosDisjuntoresMapper);
    }

    @Test
    public void testaExemplosEletrodutosMapperBean() {
        ConfiguracaoSpring configuracaoSpring = new ConfiguracaoSpring();
        ExemplosEletrodutosMapper exemplosEletrodutosMapper = configuracaoSpring.exemplosEletrodutosMapper();
        assertNotNull(exemplosEletrodutosMapper);
    }
}
