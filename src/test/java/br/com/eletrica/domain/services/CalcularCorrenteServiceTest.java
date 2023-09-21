package br.com.eletrica.domain.services;

import br.com.eletrica.common.constantes.FASES_VOLTAGEM;
import br.com.eletrica.common.exception.ValidacaoException;
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

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CalcularCorrenteServiceTest {

    @Mock
    private RepositorioNBR repositorioNBR;

    @InjectMocks
    private CalcularCorrenteService calcularCorrenteService;

    @BeforeAll
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @BeforeEach
    public void resetMocks() {
        Mockito.reset(repositorioNBR);
    }

    @Test
    public void deveCalcularComSucesso() throws ValidacaoException {
        Mockito.when(repositorioNBR.buscarFatorTemperatura(Mockito.any())).thenReturn(BigDecimal.ONE);

        var circuitoTrifasico = ModelFixture.gerarDadosCircuito();
        circuitoTrifasico.setFasesVoltagem(FASES_VOLTAGEM.TRIFASICO);
        var circuitoBifasico = ModelFixture.gerarDadosCircuito();
        circuitoBifasico.setFasesVoltagem(FASES_VOLTAGEM.BIFASICO);

        assertDoesNotThrow(() -> calcularCorrenteService.calcularCorrenteProjeto(circuitoTrifasico));
        assertDoesNotThrow(() -> calcularCorrenteService.calcularCorrenteProjeto(circuitoBifasico));
    }

    @Test
    public void deveCalcularComErroCondutoresNaoEncontrados() throws ValidacaoException {
        Mockito.when(repositorioNBR.buscarFatorTemperatura(Mockito.any())).thenReturn(null);
        assertThrows(ValidacaoException.class, () -> calcularCorrenteService.calcularCorrenteProjeto(ModelFixture.gerarDadosCircuito()));
    }
}