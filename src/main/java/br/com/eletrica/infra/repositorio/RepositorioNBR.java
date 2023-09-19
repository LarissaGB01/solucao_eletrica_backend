package br.com.eletrica.infra.repositorio;

import br.com.eletrica.common.exception.ValidacaoException;
import br.com.eletrica.domain.interfaces.IRepositorio;
import br.com.eletrica.domain.model.infra.*;
import br.com.eletrica.infra.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public class RepositorioNBR implements IRepositorio {

    private final FatorTemperaturaDao fatorTemperaturaDao;
    private final ConducaoCabosDao conducaoCabosDao;
    private final ExemplosCabosDao exemplosCabosDao;
    private final ExemplosDisjuntoresDao exemplosDisjuntoresDao;
    private final ExemplosEletrodutosDao exemplosEletrodutosDao;

    @Autowired
    public RepositorioNBR(FatorTemperaturaDao fatorTemperaturaDao, ConducaoCabosDao conducaoCabosDao,
                          ExemplosCabosDao exemplosCabosDao, ExemplosDisjuntoresDao exemplosDisjuntoresDao,
                          ExemplosEletrodutosDao exemplosEletrodutosDao) {
        this.fatorTemperaturaDao = fatorTemperaturaDao;
        this.conducaoCabosDao = conducaoCabosDao;
        this.exemplosDisjuntoresDao = exemplosDisjuntoresDao;
        this.exemplosCabosDao = exemplosCabosDao;
        this.exemplosEletrodutosDao = exemplosEletrodutosDao;
    }

    @Override
    public BigDecimal buscarFatorTemperatura(DadosBuscaFatorTemperatura dadosFatorTemperatura) throws ValidacaoException {
        return fatorTemperaturaDao.buscarFatorCorrecaoTemperatura(dadosFatorTemperatura);
    }

    @Override
    public DadosConducaoCabos buscarSecaoMinimaCabo(DadosConducaoCabos dadosConducaoCabos) throws ValidacaoException {
        return conducaoCabosDao.buscarSecaoMinimaCabo(dadosConducaoCabos);
    }

    @Override
    public DadosExemploCondutor buscarExemploCabeamento(DadosBuscaExemploCondutor dadosExemploCondutor) throws ValidacaoException {
        return exemplosCabosDao.buscarExemploCabeamento(dadosExemploCondutor);
    }

    @Override
    public DadosExemploDisjuntor buscarExemploDisjuntor(DadosBuscaExemploDisjuntor dadosExemploDisjuntor) throws ValidacaoException {
        return exemplosDisjuntoresDao.buscarExemploDisjuntores(dadosExemploDisjuntor);
    }

    @Override
    public DadosExemploEletroduto buscarExemploEletroduto(BigDecimal valorMinimoParaDiametro) throws ValidacaoException {
        return exemplosEletrodutosDao.buscarExemploEletrodutos(valorMinimoParaDiametro);
    }
}
