package br.com.eletrica.domain.validacao.disjuntores;

import br.com.eletrica.common.exception.ErrosSistema;
import br.com.eletrica.common.exception.ValidacaoException;
import br.com.eletrica.domain.model.api.requisicao.DadosEntrada;
import br.com.eletrica.domain.model.api.requisicao.DadosEntradaDisjuntores;
import br.com.eletrica.domain.validacao.Validador;
import br.com.eletrica.domain.validacao.ValidadorDisjuntores;

import java.math.BigDecimal;

public class ValidarValoresNegativosDisjuntores implements ValidadorDisjuntores {

    @Override
    public void validar(DadosEntradaDisjuntores entrada) {

        // valida corrente projeto
        if (entrada.getCorrenteProjeto() != null && entrada.getCorrenteProjeto().compareTo(BigDecimal.ZERO) <= 0) {
            throw new ValidacaoException("Corrente de projeto informada: " + entrada.getCorrenteProjeto(),
                    ErrosSistema.CORRENTE_PROJETO_INVALIDA);
        }

        // valida corrente maxima cabo
        if (entrada.getCorrenteMaximaCabo() != null && entrada.getCorrenteMaximaCabo().compareTo(BigDecimal.ZERO) <= 0) {
            throw new ValidacaoException("Corrente maxima do cabo informada: " + entrada.getCorrenteMaximaCabo(),
                    ErrosSistema.CORRENTE_MAXIMA_CABO_INVALIDA);
        }
    }
}
