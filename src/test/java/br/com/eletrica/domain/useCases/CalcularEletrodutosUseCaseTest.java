package br.com.eletrica.domain.useCases;

import br.com.eletrica.common.exception.ValidacaoException;
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

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CalcularEletrodutosUseCaseTest {
    @Mock
    private RepositorioNBR repositorioNBR;

    @Mock
    private CalcularDiametroCabosUseCase calcularDiametroCabosUseCase;

    @InjectMocks
    private CalcularEletrodutosUseCase calcularEletrodutosUseCase;

    @BeforeAll
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @BeforeEach
    public void resetMocks() {
        Mockito.reset(repositorioNBR, calcularDiametroCabosUseCase);
    }

    @Test
    public void deveCalcularComSucesso() throws ValidacaoException {
        Mockito.when(repositorioNBR.buscarExemploEletroduto(Mockito.any())).thenReturn(ModelFixture.gerarExemploEletroduto()).thenReturn(null);
        Mockito.when(calcularDiametroCabosUseCase.calcular(Mockito.any())).thenReturn(APIFixtures.gerarRespostaGeral());

        assertDoesNotThrow(() -> calcularEletrodutosUseCase.calcularComCondutores(APIFixtures.gerarRequisicaoGeral()));
        assertDoesNotThrow(() -> calcularEletrodutosUseCase.calcularSemCondutores(APIFixtures.gerarRequisicaoEletrodutos()));
    }
}