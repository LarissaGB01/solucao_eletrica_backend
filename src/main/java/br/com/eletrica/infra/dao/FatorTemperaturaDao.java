package br.com.eletrica.infra.dao;

import br.com.eletrica.common.exception.ErrosSistema;
import br.com.eletrica.common.exception.ValidacaoException;
import br.com.eletrica.common.util.ConnectionUtil;
import br.com.eletrica.domain.model.infra.DadosBuscaFatorTemperatura;
import br.com.eletrica.infra.entidade.FatorTemperatura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class FatorTemperaturaDao {

    private final ConnectionUtil connectionUtil;

    @Autowired
    public FatorTemperaturaDao(ConnectionUtil connectionUtil) {
        this.connectionUtil = connectionUtil;
    }

    public BigDecimal buscarFatorCorrecaoTemperatura(DadosBuscaFatorTemperatura dados) throws ValidacaoException {
        Connection connection = null;
        PreparedStatement statement;
        ResultSet resultSet;

        try {
            connection = connectionUtil.getConnection();

            // Alimenta parametros de consulta
            statement = connection.prepareStatement(FatorTemperatura.queryConsultar());
            statement.setBigDecimal(1, dados.getTemperatura());
            statement.setString(2, dados.getIsolacao());

            // Executa a consulta
            resultSet = statement.executeQuery();

            // Processa o resultado
            if (resultSet.next()) {
                return resultSet.getBigDecimal(FatorTemperatura.getNomeColunaFatorCorrecao());
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new ValidacaoException("Erro ao acessar a tabela " + FatorTemperatura.getNomeTabela() + "." +
                    "Codigo SQL " + e.getErrorCode(), ErrosSistema.ACESSO_BANCO_DADOS);
        } finally {
            connectionUtil.closeConnection(connection);
        }
    }
}

