package br.com.eletrica.infra.entidade;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ConducaoCabos {
    private String material;
    private BigDecimal secaoNominal;
    private String instalacao;
    private Integer condutoresCarregados;
    private BigDecimal correnteNominal;
    private String isolamento;

    public static String queryConsultar() {
        return "SELECT * " +
                "FROM " +
                "   normativas.conducao_cabos " +
                "WHERE " +
                "   instalacao = ? AND " +
                "   condutores_carregados = ? AND " +
                "   material = ? AND " +
                "   corrente_nominal >= ? AND " +
                "   isolacao = ? AND " +
                "   sessao_nominal >= ? " +
                "ORDER BY sessao_nominal ASC " +
                "LIMIT 1";
    }

    public static String getNomeTabela() {
        return "conducao_cabos";
    }
    public static String getNomeColunaInstalacao() {
        return "instalacao";
    }

    public static String getNomeColunaCondutoresCarregados() {
        return "condutores_carregados";
    }

    public static String getNomeColunaMaterial() {
        return "material";
    }

    public static String getNomeColunaCorrenteNominal() {
        return "corrente_nominal";
    }

    public static String getNomeColunaIsolacao() {
        return "isolacao";
    }

    public static String getNomeColunaSecaoNominal() {
        return "sessao_nominal";
    }
}
