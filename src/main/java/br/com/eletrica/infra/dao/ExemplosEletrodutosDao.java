package br.com.eletrica.infra.dao;

import br.com.eletrica.common.exception.ErrosSistema;
import br.com.eletrica.common.exception.ValidacaoException;
import br.com.eletrica.common.util.ConnectionUtil;
import br.com.eletrica.domain.model.infra.DadosExemploEletroduto;
import br.com.eletrica.infra.entidade.ExemplosEletrodutos;
import br.com.eletrica.infra.mapper.ExemplosEletrodutosMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class ExemplosEletrodutosDao {

    private final ConnectionUtil connectionUtil;
    private final ExemplosEletrodutosMapper mapper;

    @Autowired
    public ExemplosEletrodutosDao(ConnectionUtil connectionUtil, ExemplosEletrodutosMapper mapper) {
        this.connectionUtil = connectionUtil;
        this.mapper = mapper;
    }

    public DadosExemploEletroduto buscarExemploEletrodutos(BigDecimal minimoDiametro) throws ValidacaoException {
        Connection connection = null;
        PreparedStatement statement;
        ResultSet resultSet;

        try {
            connection = connectionUtil.getConnection();

            // Alimenta parametros de consulta
            statement = connection.prepareStatement(ExemplosEletrodutos.queryConsultar());
            statement.setBigDecimal(1, minimoDiametro);

            // Executa a consulta
            resultSet = statement.executeQuery();

            // Processa o resultado
            if (resultSet.next()) {
                ExemplosEletrodutos eletroduto = new ExemplosEletrodutos();
                eletroduto.setDiametroExterno(resultSet.getBigDecimal(ExemplosEletrodutos.getNomeColunaDiametroExterno()));
                eletroduto.setDiametroInterno(resultSet.getBigDecimal(ExemplosEletrodutos.getNomeColunaDiametroInterno()));
                eletroduto.setDiametroNominalMilimetros(resultSet.getInt(ExemplosEletrodutos.getNomeColunaDiametroNominalMilimetros()));
                eletroduto.setDiametroNominalPolegadas(resultSet.getString(ExemplosEletrodutos.getNomeColunaDiametroNominalPolegadas()));
                return mapper.toDomain(eletroduto);
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new ValidacaoException("Erro ao acessar a tabela " + ExemplosEletrodutos.getNomeTabela() + "." +
                    "Codigo SQL " + e.getErrorCode(), ErrosSistema.ACESSO_BANCO_DADOS);
        } finally {
            connectionUtil.closeConnection(connection);
        }
    }
}

