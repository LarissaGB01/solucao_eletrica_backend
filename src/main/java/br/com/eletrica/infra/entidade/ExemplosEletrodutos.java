package br.com.eletrica.infra.entidade;

import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;

@Getter
@Setter
public class ExemplosEletrodutos {
    private String diametroNominalPolegadas;
    private int diametroNominalMilimetros;
    private BigDecimal diametroExterno;
    private BigDecimal diametroInterno;

    public static String getNomeTabela() {
        return "exemplos_eletrodutos";
    }

    public static String getNomeColunaDiametroNominalPolegadas() {
        return "diametro_nominal_polegadas";
    }

    public static String getNomeColunaDiametroNominalMilimetros() {
        return "diametro_nominal_milimetros";
    }

    public static String getNomeColunaDiametroExterno() {
        return "diametro_externo";
    }

    public static String getNomeColunaDiametroInterno() {
        return "diametro_interno";
    }

    public static String queryConsultar() {
        return "SELECT " +
                "   diametro_interno, " +
                "   diametro_externo, " +
                "   diametro_nominal_milimetros," +
                "   diametro_nominal_polegadas " +
                "FROM " +
                "   normativas.exemplos_eletrodutos " +
                "WHERE " +
                "   diametro_externo > ? " +
                "ORDER BY diametro_interno ASC " +
                "LIMIT 1";
    }
}
