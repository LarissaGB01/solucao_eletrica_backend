package br.com.eletrica.infra.dao;

import br.com.eletrica.common.exception.ErrosSistema;
import br.com.eletrica.common.exception.ValidacaoException;
import br.com.eletrica.common.util.ConnectionUtil;
import br.com.eletrica.domain.model.infra.DadosBuscaExemploCondutor;
import br.com.eletrica.domain.model.infra.DadosExemploCondutor;
import br.com.eletrica.infra.entidade.ExemplosCabos;
import br.com.eletrica.infra.mapper.ExemplosCabosMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class ExemplosCabosDao {

    private final ConnectionUtil connectionUtil;
    private final ExemplosCabosMapper mapper;

    @Autowired
    public ExemplosCabosDao(ConnectionUtil connectionUtil, ExemplosCabosMapper mapper) {
        this.connectionUtil = connectionUtil;
        this.mapper = mapper;
    }

    public DadosExemploCondutor buscarExemploCabeamento(DadosBuscaExemploCondutor dados) throws ValidacaoException {
        Connection connection = null;
        PreparedStatement statement;
        ResultSet resultSet;

        try {
            connection = connectionUtil.getConnection();

            // Alimenta parametros de consulta
            statement = connection.prepareStatement(ExemplosCabos.queryConsultar());
            statement.setBigDecimal(1, dados.getSecaoNominal());
            statement.setInt(2, dados.getCabosCarregados());

            // Executa a consulta
            resultSet = statement.executeQuery();

            // Processa o resultado
            if (resultSet.next()) {
                ExemplosCabos conducaoCabos = new ExemplosCabos();
                conducaoCabos.setDiametroNominalCondutor(resultSet.getBigDecimal(ExemplosCabos.getNomeColunaDiametroNominalCondutor()));
                conducaoCabos.setSecaoNominal(resultSet.getBigDecimal(ExemplosCabos.getNomeColunaSecaoNominal()));
                conducaoCabos.setDiametroNominalExterno(resultSet.getBigDecimal(ExemplosCabos.getNomeColunaDiametroNominalExterno()));
                conducaoCabos.setCabosCarregados(resultSet.getInt(ExemplosCabos.getNomeColunaCabosCarregados()));
                return mapper.toDomain(conducaoCabos);
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new ValidacaoException("Erro ao acessar a tabela " + ExemplosCabos.getNomeTabela() + "." +
                    "Codigo SQL " + e.getErrorCode(), ErrosSistema.ACESSO_BANCO_DADOS);
        } finally {
            connectionUtil.closeConnection(connection);
        }
    }
}

