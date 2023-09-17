package br.com.eletrica.domain.model.api.resposta.calculo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CalculoSecaoCondutor {
    private CalculoPotenciaAparente calculoPotenciaAparente = new CalculoPotenciaAparente();
    private CalculoCorrenteProjeto calculoCorrenteProjeto = new CalculoCorrenteProjeto();
    private CalculoDiametroMinimoCabo calculoDiametroMinimoCabo = new CalculoDiametroMinimoCabo();
}
