package br.com.eletrica.infra.repositorio;

import br.com.eletrica.domain.interfaces.IRepositorio;
import br.com.eletrica.domain.model.infra.DadosConducaoCabos;
import br.com.eletrica.domain.model.infra.DadosFatorTemperatura;
import br.com.eletrica.infra.dao.ConducaoCabosDao;
import br.com.eletrica.infra.dao.FatorTemperaturaDao;

import java.math.BigDecimal;
import java.sql.SQLException;

public class RepositorioNBR implements IRepositorio {
    @Override
    public BigDecimal buscarFatorTemperatura(DadosFatorTemperatura dadosFatorTemperatura) throws SQLException {
        var dao = new FatorTemperaturaDao();
        return dao.buscarFatorCorrecaoTemperatura(dadosFatorTemperatura);
    }

    @Override
    public DadosConducaoCabos buscarSecaoMinimaCabo(DadosConducaoCabos dadosConducaoCabos) throws SQLException {
        var dao = new ConducaoCabosDao();
        return dao.buscarSecaoMinimaCabo(dadosConducaoCabos);
    }
}
