package br.com.eletrica.domain.model.api.resposta.dimensionado;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class DadosCabeamento {
    private BigDecimal correnteMaximaCondutor = BigDecimal.ZERO;
    private BigDecimal secaoNominalCondutor = BigDecimal.ZERO;
    private BigDecimal diametroExternoCaboRecomendado = BigDecimal.ZERO;
    private BigDecimal diametroNominalCaboRecomendado = BigDecimal.ZERO;
}
