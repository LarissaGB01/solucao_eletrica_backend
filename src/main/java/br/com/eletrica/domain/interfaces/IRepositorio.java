package br.com.eletrica.domain.interfaces;

import br.com.eletrica.common.exception.ValidacaoException;
import br.com.eletrica.domain.model.infra.DadosConducaoCabos;
import br.com.eletrica.domain.model.infra.DadosExemploCondutor;
import br.com.eletrica.domain.model.infra.DadosFatorTemperatura;

import java.math.BigDecimal;

public interface IRepositorio {
    BigDecimal buscarFatorTemperatura(DadosFatorTemperatura dadosFatorTemperatura) throws ValidacaoException;
    DadosConducaoCabos buscarSecaoMinimaCabo(DadosConducaoCabos dadosConducaoCabos) throws ValidacaoException;
    DadosExemploCondutor buscarExemploCabeamento(DadosExemploCondutor dadosExemploCondutor) throws ValidacaoException;
}
