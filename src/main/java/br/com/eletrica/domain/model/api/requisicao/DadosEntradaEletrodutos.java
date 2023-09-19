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
public class DadosEntradaEletrodutos {

    @Id
    @ApiModelProperty(required = true, example = "25.0")
    private BigDecimal diametroCabo = BigDecimal.ZERO;

    @ApiModelProperty(required = true, example = "2")
    private Integer quantidadeCondutores;
}
