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
public class CalcularDisjuntoresUseCaseTest {
    @Mock
    private RepositorioNBR repositorioNBR;

    @Mock
    private CalcularDiametroCabosUseCase calcularDiametroCabosUseCase;

    @InjectMocks
    private CalcularDisjuntoresUseCase calcularDisjuntoresUseCase;

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
        Mockito.when(repositorioNBR.buscarExemploDisjuntor(Mockito.any())).thenReturn(ModelFixture.gerarExemploDisjuntor()).thenReturn(null);
        Mockito.when(calcularDiametroCabosUseCase.calcular(Mockito.any())).thenReturn(APIFixtures.gerarRespostaGeral());

        assertDoesNotThrow(() -> calcularDisjuntoresUseCase.calcularComCondutores(APIFixtures.gerarRequisicaoGeral()));
        assertDoesNotThrow(() -> calcularDisjuntoresUseCase.calcularSemCondutores(APIFixtures.gerarRequisicaoDisjuntores()));
    }
}