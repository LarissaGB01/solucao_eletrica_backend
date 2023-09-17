package br.com.eletrica.infra.repositorio;

import br.com.eletrica.common.exception.ValidacaoException;
import br.com.eletrica.domain.interfaces.IRepositorio;
import br.com.eletrica.domain.model.infra.DadosConducaoCabos;
import br.com.eletrica.domain.model.infra.DadosExemploCondutor;
import br.com.eletrica.domain.model.infra.DadosFatorTemperatura;
import br.com.eletrica.infra.dao.ConducaoCabosDao;
import br.com.eletrica.infra.dao.ExemplosCabosDao;
import br.com.eletrica.infra.dao.FatorTemperaturaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public class RepositorioNBR implements IRepositorio {

    private final FatorTemperaturaDao fatorTemperaturaDao;
    private final ConducaoCabosDao conducaoCabosDao;
    private final ExemplosCabosDao exemplosCabosDao;

    @Autowired
    public RepositorioNBR(FatorTemperaturaDao fatorTemperaturaDao, ConducaoCabosDao conducaoCabosDao, ExemplosCabosDao exemplosCabosDao) {
        this.fatorTemperaturaDao = fatorTemperaturaDao;
        this.conducaoCabosDao = conducaoCabosDao;
        this.exemplosCabosDao = exemplosCabosDao;
    }

    @Override
    public BigDecimal buscarFatorTemperatura(DadosFatorTemperatura dadosFatorTemperatura) throws ValidacaoException {
        return fatorTemperaturaDao.buscarFatorCorrecaoTemperatura(dadosFatorTemperatura);
    }

    @Override
    public DadosConducaoCabos buscarSecaoMinimaCabo(DadosConducaoCabos dadosConducaoCabos) throws ValidacaoException {
        return conducaoCabosDao.buscarSecaoMinimaCabo(dadosConducaoCabos);
    }

    @Override
    public DadosExemploCondutor buscarExemploCabeamento(DadosExemploCondutor dadosExemploCondutor) throws ValidacaoException {
        return exemplosCabosDao.buscarExemploCabeamento(dadosExemploCondutor);
    }
}
