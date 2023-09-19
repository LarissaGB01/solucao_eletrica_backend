package br.com.eletrica.domain.model.api.resposta.dimensionado;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
public class DadosEletroduto {

    @Id
    private String diametroNominalEletrodutoSugeridoPolegadas;
    private int diametroNominalEletrodutoSugeridoMilimetros;
    private BigDecimal diametroExternoEletrodutoSugerido;
    private BigDecimal diametroInternoEletrodutoSugerido;
}
