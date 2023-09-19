package br.com.eletrica.domain.model.api.requisicao;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
public class DadosEntradaDisjuntores {

    @Id
    @ApiModelProperty(required = true, example = "45")
    private BigDecimal correnteProjeto = BigDecimal.ZERO;

    @ApiModelProperty(required = true, example = "63.0")
    private BigDecimal correnteMaximaCabo = BigDecimal.ZERO;

    @ApiModelProperty(required = true, example = "TRIFASICO")
    private String fasesVoltagem;
}
