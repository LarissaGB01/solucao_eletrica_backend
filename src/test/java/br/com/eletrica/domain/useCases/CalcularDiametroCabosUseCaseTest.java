package br.com.eletrica.domain.useCases;

import br.com.eletrica.common.exception.ValidacaoException;
import br.com.eletrica.domain.model.mappers.DadosCircuitoMapper;
import br.com.eletrica.domain.services.CalcularCorrenteService;
import br.com.eletrica.domain.services.CalcularDiametroCaboService;
import br.com.eletrica.domain.services.CalcularPotenciaService;
import br.com.eletrica.fixtures.APIFixtures;
import br.com.eletrica.fixtures.ModelFixture;
import br.com.eletrica.infra.repositorio.RepositorioNBR;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CalcularDiametroCabosUseCaseTest {

    @Mock
    private DadosCircuitoMapper mapper;

    @Mock
    private RepositorioNBR repositorioNBR;

    @Mock
    private CalcularCorrenteService calcularCorrenteService;

    @Mock
    private CalcularPotenciaService calcularPotenciaService;

    @Mock
    private CalcularDiametroCaboService calcularDiametroCaboService;

    @InjectMocks
    private CalcularDiametroCabosUseCase calcularDiametroCabosUseCase;

    @BeforeAll
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @BeforeEach
    public void resetMocks() {
        Mockito.reset(mapper, repositorioNBR, calcularCorrenteService, calcularPotenciaService, calcularDiametroCaboService);
    }

    @Test
    public void deveCalcularComSucesso() throws ValidacaoException {
        var diametroComMinimo = APIFixtures.gerarCalculoCabeamento();
        diametroComMinimo.setIndicadorMinimoDiametroUtilizado(true);
        var diametroSemMinimo = APIFixtures.gerarCalculoCabeamento();
        diametroSemMinimo.setIndicadorMinimoDiametroUtilizado(false);

        Mockito.when(mapper.toDomain(Mockito.any())).thenReturn(ModelFixture.gerarDadosCircuito());
        Mockito.when(calcularCorrenteService.calcularCorrenteProjeto(Mockito.any())).thenReturn(APIFixtures.gerarCalculoCorrenteProjeto());
        Mockito.when(calcularPotenciaService.calcularAparente(Mockito.any(), Mockito.any(), Mockito.any())).thenReturn(ModelFixture.gerarDadosPotencia());
        Mockito.when(calcularDiametroCaboService.calcular(Mockito.any(), Mockito.any())).thenReturn(diametroComMinimo).thenReturn(diametroSemMinimo);
        Mockito.when(repositorioNBR.buscarSecaoMinimaCabo(Mockito.any())).thenReturn(ModelFixture.gerarDadosConducaoCabos());
        Mockito.when(repositorioNBR.buscarExemploCabeamento(Mockito.any())).thenReturn(ModelFixture.gerarExemploCabeamento()).thenReturn(null);

        assertDoesNotThrow(() -> calcularDiametroCabosUseCase.calcular(APIFixtures.gerarRequisicaoGeral()));
        assertDoesNotThrow(() -> calcularDiametroCabosUseCase.calcular(APIFixtures.gerarRequisicaoGeral()));
    }

    @Test
    public void deveCalcularComErroCondutoresNaoEncontrados() throws ValidacaoException {
        Mockito.when(mapper.toDomain(Mockito.any())).thenReturn(ModelFixture.gerarDadosCircuito());
        Mockito.when(calcularCorrenteService.calcularCorrenteProjeto(Mockito.any())).thenReturn(APIFixtures.gerarCalculoCorrenteProjeto());
        Mockito.when(calcularDiametroCaboService.calcular(Mockito.any(), Mockito.any())).thenReturn(APIFixtures.gerarCalculoCabeamento());
        Mockito.when(calcularPotenciaService.calcularAparente(Mockito.any(), Mockito.any(), Mockito.any())).thenReturn(ModelFixture.gerarDadosPotencia());
        Mockito.when(repositorioNBR.buscarSecaoMinimaCabo(Mockito.any())).thenReturn(null);

        assertThrows(ValidacaoException.class, () -> calcularDiametroCabosUseCase.calcular(APIFixtures.gerarRequisicaoGeral()));
    }
}