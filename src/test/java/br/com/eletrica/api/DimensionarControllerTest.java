package br.com.eletrica.api;

import br.com.eletrica.common.exception.ErroResponse;
import br.com.eletrica.common.exception.ErrosSistema;
import br.com.eletrica.common.exception.ValidacaoException;
import br.com.eletrica.domain.model.api.requisicao.DadosEntrada;
import br.com.eletrica.domain.useCases.CalcularDiametroCabosUseCase;
import br.com.eletrica.domain.useCases.CalcularDisjuntoresUseCase;
import br.com.eletrica.domain.useCases.CalcularEletrodutosUseCase;
import br.com.eletrica.fixtures.APIFixtures;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class DimensionarControllerTest {

    @Mock
    private CalcularDiametroCabosUseCase useCaseCondutores;

    @Mock
    private CalcularDisjuntoresUseCase useCaseDisjuntores;

    @Mock
    private CalcularEletrodutosUseCase useCaseEletrodutos;

    @InjectMocks
    private DimensionarController dimensionarController;

    @BeforeAll
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @BeforeEach
    public void resetMocks() {
        Mockito.reset(useCaseCondutores, useCaseDisjuntores, useCaseEletrodutos);
    }

    @Test
    public void testaDimensionarGeral() {
        Mockito.when(useCaseCondutores.calcular(Mockito.any())).thenReturn(APIFixtures.gerarRespostaGeral());
        Mockito.when(useCaseDisjuntores.calcularComCondutores(Mockito.any())).thenReturn(APIFixtures.gerarRespostaGeral());
        Mockito.when(useCaseEletrodutos.calcularComCondutores(Mockito.any())).thenReturn(APIFixtures.gerarRespostaGeral());

        Assertions.assertNotNull(dimensionarController.dimensionar(APIFixtures.gerarRequisicaoGeral()));
        Assertions.assertNotNull(dimensionarController.dimensionar(new DadosEntrada()));
    }

    @Test
    public void testaDimensionarCondutores() {
        Mockito.when(useCaseCondutores.calcular(Mockito.any())).thenReturn(APIFixtures.gerarRespostaGeral());
        Assertions.assertNotNull(dimensionarController.dimensionarCondutores(APIFixtures.gerarRequisicaoGeral()));
    }

    @Test
    public void testaDimensionarDisjuntores() {
        Mockito.when(useCaseDisjuntores.calcularSemCondutores(Mockito.any())).thenReturn(APIFixtures.gerarRespostaGeral());
        Assertions.assertNotNull(dimensionarController.dimensionarDisjuntores(APIFixtures.gerarRequisicaoDisjuntores()));
    }

    @Test
    public void testDimensionarEletrodutos() {
        Mockito.when(useCaseEletrodutos.calcularSemCondutores(Mockito.any())).thenReturn(APIFixtures.gerarRespostaGeral());
        Assertions.assertNotNull(dimensionarController.dimensionarEletrodutos(APIFixtures.gerarRequisicaoEletrodutos()));
    }

    @Test
    public void testFormatarExcecao() throws JsonProcessingException {
        ValidacaoException validacaoException = new ValidacaoException("Erro de validação", ErrosSistema.ACESSO_BANCO_DADOS);
        Mockito.when(useCaseCondutores.calcular(Mockito.any())).thenThrow(validacaoException);

        ResponseEntity<ErroResponse> response = dimensionarController.formatarExcecao(validacaoException);

        Assertions.assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        Assertions.assertNotNull(response.getBody());
        Assertions.assertEquals(400, response.getBody().getCodigo());
        Assertions.assertEquals("Erro ao acessar banco de dados.", response.getBody().getMensagem());
        Assertions.assertEquals("Erro de validação", response.getBody().getMotivo());
    }
}
