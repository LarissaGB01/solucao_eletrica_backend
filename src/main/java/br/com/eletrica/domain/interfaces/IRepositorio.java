package br.com.eletrica.domain.interfaces;

import br.com.eletrica.domain.model.infra.DadosConducaoCabos;
import br.com.eletrica.domain.model.infra.DadosFatorTemperatura;
import br.com.eletrica.infra.entidade.ConducaoCabos;

import java.math.BigDecimal;
import java.sql.SQLException;

public interface IRepositorio {
    BigDecimal buscarFatorTemperatura(DadosFatorTemperatura dadosFatorTemperatura) throws SQLException;
    DadosConducaoCabos buscarSecaoMinimaCabo(DadosConducaoCabos dadosConducaoCabos) throws SQLException;
}
