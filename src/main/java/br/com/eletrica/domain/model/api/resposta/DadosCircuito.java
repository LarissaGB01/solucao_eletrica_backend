package br.com.eletrica.domain.model.api.resposta;

import br.com.eletrica.common.constantes.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class DadosCircuito {

    // dados do circuito
    private TIPO_UTILIZACAO utilizacaoCircuito;
    private TIPO_CIRCUITO tipoCircuito;
    private METODO_INSTALACAO metodoInstalacao;
    private TIPO_CABO tipoCabo;
    private Integer temperaturaAmbiente;
    private Integer quantidadeCircuitosAgrupados;
    private Integer comprimentoFio;

    // dados eletricos
    private FASES_VOLTAGEM fasesVoltagem;
    private Integer voltagem;
    private BigDecimal potenciaAtiva = BigDecimal.ZERO;
    private BigDecimal potenciaAparente = BigDecimal.ZERO;
    private BigDecimal fatorDePotencia = BigDecimal.ZERO;
    private BigDecimal correnteProjeto = BigDecimal.ZERO;
}
