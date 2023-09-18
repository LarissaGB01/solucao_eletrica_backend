package br.com.eletrica.infra.dao;

import br.com.eletrica.common.exception.ErrosSistema;
import br.com.eletrica.common.exception.ValidacaoException;
import br.com.eletrica.common.util.ConnectionUtil;
import br.com.eletrica.domain.model.infra.DadosBuscaExemploDisjuntor;
import br.com.eletrica.domain.model.infra.DadosExemploDisjuntor;
import br.com.eletrica.infra.entidade.ExemplosDisjuntores;
import br.com.eletrica.infra.mapper.ExemplosDisjuntoresMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class ExemplosDisjuntoresDao {

    private final ConnectionUtil connectionUtil;
    private final ExemplosDisjuntoresMapper mapper;

    @Autowired
    public ExemplosDisjuntoresDao(ConnectionUtil connectionUtil, ExemplosDisjuntoresMapper mapper) {
        this.connectionUtil = connectionUtil;
        this.mapper = mapper;
    }

    public DadosExemploDisjuntor buscarExemploDisjuntores(DadosBuscaExemploDisjuntor dados) throws ValidacaoException {
        Connection connection = null;
        PreparedStatement statement;
        ResultSet resultSet;

        try {
            connection = connectionUtil.getConnection();

            // Alimenta parametros de consulta
            statement = connection.prepareStatement(ExemplosDisjuntores.queryConsultar());
            statement.setBigDecimal(1, dados.getCorrenteProjeto());
            statement.setBigDecimal(2, dados.getCorrenteMaximaCabo());
            statement.setInt(3, dados.getCondutoresCarregados());

            // Executa a consulta
            System.out.println(statement.toString());
            resultSet = statement.executeQuery();

            // Processa o resultado
            if (resultSet.next()) {
                ExemplosDisjuntores disjuntor = new ExemplosDisjuntores();
                disjuntor.setNomeDisjuntor(resultSet.getString(ExemplosDisjuntores.getNomeColunaNomeDisjuntor()));
                disjuntor.setCorrenteNominal(resultSet.getInt(ExemplosDisjuntores.getNomeColunaCorrenteNominal()));
                return mapper.toDomain(disjuntor);
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new ValidacaoException("Erro ao acessar a tabela " + ExemplosDisjuntores.getNomeTabela() + "." +
                    "Codigo SQL " + e.getErrorCode(), ErrosSistema.ACESSO_BANCO_DADOS);
        } finally {
            connectionUtil.closeConnection(connection);
        }
    }
}

