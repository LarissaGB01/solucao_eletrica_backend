package br.com.eletrica.domain.interfaces;

import br.com.eletrica.common.exception.ValidacaoException;
import br.com.eletrica.domain.model.infra.*;

import java.math.BigDecimal;

public interface IRepositorio {
    BigDecimal buscarFatorTemperatura(DadosBuscaFatorTemperatura dadosFatorTemperatura) throws ValidacaoException;
    DadosConducaoCabos buscarSecaoMinimaCabo(DadosConducaoCabos dadosConducaoCabos) throws ValidacaoException;
    DadosExemploCondutor buscarExemploCabeamento(DadosBuscaExemploCondutor dadosExemploCondutor) throws ValidacaoException;
    DadosExemploDisjuntor buscarExemploDisjuntor(DadosBuscaExemploDisjuntor dadosExemploDisjuntor) throws ValidacaoException;
}
