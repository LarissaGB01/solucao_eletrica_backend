package br.com.eletrica.domain.validacao.disjuntores;

import br.com.eletrica.common.constantes.*;
import br.com.eletrica.common.exception.ErrosSistema;
import br.com.eletrica.common.exception.ValidacaoException;
import br.com.eletrica.common.util.FieldUtil;
import br.com.eletrica.domain.model.api.requisicao.DadosEntradaDisjuntores;
import br.com.eletrica.domain.validacao.ValidadorDisjuntores;

public class ValidarConstantesDisjuntores implements ValidadorDisjuntores {

    @Override
    public void validar(DadosEntradaDisjuntores entrada) throws ValidacaoException {
        // valida fases voltagem
        if (entrada.getFasesVoltagem() == null ||
                FieldUtil.enumNaoContem(FASES_VOLTAGEM.class, entrada.getFasesVoltagem())) {
            throw new ValidacaoException("Fases de voltagem informada: " + entrada.getFasesVoltagem() + ". " +
                    "Valores aceitos: " + FieldUtil.listarEnums(FASES_VOLTAGEM.class) + ".",
                    ErrosSistema.FASES_SISTEMA_INVALIDA);
        }
    }
}
