package br.com.eletrica.domain.model.api.requisicao;

import br.com.eletrica.common.constantes.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class DadosEntrada {

    private String utilizacaoCircuito;
    private String tipoCircuito;
    private String fasesVoltagem;
    private Integer voltagem;
    private String metodoInstalacao;
    private String tipoCabo;
    private BigDecimal potenciaAtiva;
    private BigDecimal potenciaAparente;
    private BigDecimal fatorDePotencia;
    private Integer temperaturaAmbiente;
    private Integer quantidadeCircuitosAgrupados;
    private Integer comprimentoFio;

}
