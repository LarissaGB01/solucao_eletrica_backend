package br.com.eletrica.infra.entidade;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ExemplosCabos {
    private int cabosCarregados;
    private BigDecimal secaoNominal;
    private BigDecimal diametroNominalCondutor;
    private BigDecimal diametroNominalExterno;

    public static String getNomeTabela() {
        return "exemplos_cabos";
    }

    public static String getNomeColunaCabosCarregados() {
        return "cabos_carregados";
    }

    public static String getNomeColunaSecaoNominal() {
        return "secao_nominal";
    }

    public static String getNomeColunaDiametroNominalCondutor() {
        return "diametro_nominal_condutor";
    }

    public static String getNomeColunaDiametroNominalExterno() {
        return "diametro_nominal_externo";
    }

    public static String queryConsultar() {
        return "SELECT " +
                "   diametro_nominal_condutor, " +
                "   diametro_nominal_externo, " +
                "   secao_nominal, " +
                "   cabos_carregados " +
                "FROM " +
                "   normativas.exemplos_cabos " +
                "WHERE " +
                "   secao_nominal = ? AND " +
                "   cabos_carregados = ? " +
                "LIMIT 1";
    }
}
