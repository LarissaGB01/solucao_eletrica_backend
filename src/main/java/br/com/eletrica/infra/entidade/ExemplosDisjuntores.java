package br.com.eletrica.infra.entidade;

import lombok.Getter;
import lombok.Setter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Getter
@Setter
public class ExemplosDisjuntores {
    private int correnteNominal;
    private int condutoresCarregados;
    private String nomeDisjuntor;

    public static String getNomeTabela() {
        return "exemplos_disjuntores";
    }

    public static String getNomeColunaCorrenteNominal() {
        return "corrente_nominal";
    }

    public static String getNomeColunaCondutoresCarregados() {
        return "condutores_carregados";
    }

    public static String getNomeColunaNomeDisjuntor() {
        return "nome_disjuntor";
    }

    public static String queryConsultar() {
        return "SELECT " +
                "   corrente_nominal, " +
                "   condutores_carregados, " +
                "   nome_disjuntor " +
                "FROM " +
                "   normativas.exemplos_disjuntores " +
                "WHERE " +
                "   corrente_nominal > ? AND " +
                "   corrente_nominal < ? AND " +
                "   condutores_carregados = ? " +
                "ORDER BY corrente_nominal ASC " +
                "LIMIT 1";
    }
}
