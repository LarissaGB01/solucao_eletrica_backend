package br.com.eletrica.infra.dao;

import br.com.eletrica.common.exception.ErrosSistema;
import br.com.eletrica.common.exception.ValidacaoException;
import br.com.eletrica.common.util.ConnectionUtil;
import br.com.eletrica.domain.model.infra.DadosConducaoCabos;
import br.com.eletrica.infra.entidade.ConducaoCabos;
import br.com.eletrica.infra.mapper.ConducaoCabosMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class ConducaoCabosDao {

    private final ConnectionUtil connectionUtil;
    private final ConducaoCabosMapper mapper;

    @Autowired
    public ConducaoCabosDao(ConnectionUtil connectionUtil, ConducaoCabosMapper mapper) {
        this.connectionUtil = connectionUtil;
        this.mapper = mapper;
    }

    public DadosConducaoCabos buscarSecaoMinimaCabo(DadosConducaoCabos dados) throws ValidacaoException {
        Connection connection = null;
        PreparedStatement statement;
        ResultSet resultSet;

        try {
            connection = connectionUtil.getConnection();

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
                conducaoCabos.setMaterial(resultSet.getString(ConducaoCabos.getNomeColunaMaterial()));
                conducaoCabos.setSecaoNominal(resultSet.getBigDecimal(ConducaoCabos.getNomeColunaSecaoNominal()));
                conducaoCabos.setInstalacao(resultSet.getString(ConducaoCabos.getNomeColunaInstalacao()));
                conducaoCabos.setCondutoresCarregados(resultSet.getInt(ConducaoCabos.getNomeColunaCondutoresCarregados()));
                conducaoCabos.setCorrenteNominal(resultSet.getBigDecimal(ConducaoCabos.getNomeColunaCorrenteNominal()));
                conducaoCabos.setIsolamento(resultSet.getString(ConducaoCabos.getNomeColunaIsolacao()));
                return mapper.toDomain(conducaoCabos);
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new ValidacaoException("Erro ao acessar a tabela " + ConducaoCabos.getNomeTabela() + "." +
                    "Codigo SQL " + e.getErrorCode(), ErrosSistema.ACESSO_BANCO_DADOS);
        } finally {
            connectionUtil.closeConnection(connection);
        }
    }
}

