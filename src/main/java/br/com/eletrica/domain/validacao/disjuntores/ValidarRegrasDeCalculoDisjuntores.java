package br.com.eletrica.domain.validacao.disjuntores;

import br.com.eletrica.common.exception.ErrosSistema;
import br.com.eletrica.common.exception.ValidacaoException;
import br.com.eletrica.common.util.FieldUtil;
import br.com.eletrica.domain.model.api.requisicao.DadosEntrada;
import br.com.eletrica.domain.model.api.requisicao.DadosEntradaDisjuntores;
import br.com.eletrica.domain.validacao.Validador;
import br.com.eletrica.domain.validacao.ValidadorDisjuntores;

public class ValidarRegrasDeCalculoDisjuntores implements ValidadorDisjuntores {

    @Override
    public void validar(DadosEntradaDisjuntores entrada) {
        if (entrada.getCorrenteMaximaCabo().compareTo(entrada.getCorrenteProjeto()) <= 0) {
            throw new ValidacaoException("Corrente maxima do cabo informada: " + entrada.getCorrenteMaximaCabo() +
                    " // Corrente de projeto informada: " + entrada.getCorrenteProjeto(),
                    ErrosSistema.CORRENTES_INFORMADAS_INVALIDAS);
        }
    }
}
