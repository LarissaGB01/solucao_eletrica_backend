package br.com.eletrica.infra.dao;

import br.com.eletrica.common.util.ConnectionUtil;
import br.com.eletrica.domain.model.infra.DadosConducaoCabos;
import br.com.eletrica.infra.entidade.ConducaoCabos;
import br.com.eletrica.infra.mapper.ConducaoCabosMapper;

import java.sql.*;

public class ConducaoCabosDao {

    public DadosConducaoCabos buscarSecaoMinimaCabo(DadosConducaoCabos dados) throws SQLException {
        Connection connection = null;
        PreparedStatement statement;
        ResultSet resultSet;
        var mapper = new ConducaoCabosMapper();

        try {
            connection = ConnectionUtil.getConnection();

            // Alimenta parametros de consulta
            statement = connection.prepareStatement(ConducaoCabos.queryConsultar());
            statement.setString(1, dados.getInstalacao());
            statement.setInt(2, dados.getCondutoresCarregados());
            statement.setString(3, dados.getMaterial());
            statement.setBigDecimal(4, dados.getCorrenteNominal());
            statement.setString(5, dados.getIsolamento());
            statement.setBigDecimal(6, dados.getSecaoNominal());

            // Executa a consulta
            resultSet = statement.executeQuery();

            // Processa o resultado
            if (resultSet.next()) {
                ConducaoCabos conducaoCabos = new ConducaoCabos();
                conducaoCabos.setMaterial(resultSet.getString("material"));
                conducaoCabos.setSecaoNominal(resultSet.getBigDecimal("sessao_nominal"));
                conducaoCabos.setInstalacao(resultSet.getString("instalacao"));
                conducaoCabos.setCondutoresCarregados(resultSet.getInt("condutores_carregados"));
                conducaoCabos.setCorrenteNominal(resultSet.getBigDecimal("corrente_nominal"));
                conducaoCabos.setIsolamento(resultSet.getString("isolacao"));
                return mapper.toDomain(conducaoCabos);
            } else {
                return null;
            }
        } catch (RuntimeException e) {
            e.printStackTrace();
            return null;
        } finally {
            ConnectionUtil.closeConnection(connection);
        }
    }
}

