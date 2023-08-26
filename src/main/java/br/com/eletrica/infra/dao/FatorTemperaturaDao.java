package br.com.eletrica.infra.dao;

import br.com.eletrica.common.util.ConnectionUtil;
import br.com.eletrica.domain.model.infra.DadosFatorTemperatura;
import br.com.eletrica.infra.entidade.FatorTemperatura;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

public class FatorTemperaturaDao {

    public BigDecimal buscarFatorCorrecaoTemperatura(DadosFatorTemperatura dados) throws SQLException {
        Connection connection = null;
        PreparedStatement statement;
        ResultSet resultSet;

        try {
            connection = ConnectionUtil.getConnection();

            // Alimenta parametros de consulta
            statement = connection.prepareStatement(FatorTemperatura.queryConsultar());
            statement.setBigDecimal(1, dados.getTemperatura());
            statement.setString(2, dados.getIsolacao());
            System.out.println(statement.toString());

            // Executa a consulta
            resultSet = statement.executeQuery();

            // Processa o resultado
            if (resultSet.next()) {
                return resultSet.getBigDecimal("fator_correcao");
            } else {
                System.out.println(BigDecimal.ZERO);
                return BigDecimal.ZERO;
            }
        } catch (RuntimeException e) {
            System.out.println(BigDecimal.ONE);
            e.printStackTrace();
            return BigDecimal.ZERO;
        } finally {
            ConnectionUtil.closeConnection(connection);
        }
    }
}

