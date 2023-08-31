package br.com.eletrica.domain.validacao;

import br.com.eletrica.common.constantes.*;
import br.com.eletrica.common.exception.ErrosSistema;
import br.com.eletrica.common.exception.ValidacaoException;
import br.com.eletrica.common.util.FieldUtil;
import br.com.eletrica.domain.model.api.requisicao.DadosEntrada;

public class ValidarConstantes implements Validador {

    @Override
    public void validar(DadosEntrada entrada) throws ValidacaoException {

        // valida utilizacao do circuito
        if (entrada.getUtilizacaoCircuito() == null ||
                FieldUtil.enumContem(TIPO_UTILIZACAO.class, entrada.getUtilizacaoCircuito())) {
            throw new ValidacaoException("Utilizacao do circuito informada: " + entrada.getUtilizacaoCircuito() + ". " +
                    "Valores aceitos: " + FieldUtil.listarEnums(TIPO_UTILIZACAO.class) + ".",
                    ErrosSistema.FINALIDADE_CIRCUITO_INVALIDA);
        }

        // valida fases voltagem
        if (entrada.getFasesVoltagem() == null ||
                FieldUtil.enumContem(FASES_VOLTAGEM.class, entrada.getFasesVoltagem())) {
            throw new ValidacaoException("Fases de voltagem informada: " + entrada.getFasesVoltagem() + ". " +
                    "Valores aceitos: " + FieldUtil.listarEnums(FASES_VOLTAGEM.class) + ".",
                    ErrosSistema.FASES_SISTEMA_INVALIDA);
        }

        // valida metodo de instalacao
        if (entrada.getMetodoInstalacao() == null ||
                FieldUtil.enumContem(METODO_INSTALACAO.class, entrada.getMetodoInstalacao())) {
            throw new ValidacaoException("Metodo de instalacao informado: " + entrada.getMetodoInstalacao() + ". " +
                    "Valores aceitos: " + FieldUtil.listarEnums(METODO_INSTALACAO.class) + ".",
                    ErrosSistema.TIPO_DE_INSTALACAO_INVALIDA);
        }

        // valida tipo do cabo
        if (entrada.getTipoCabo() == null ||
                FieldUtil.enumContem(TIPO_CABO.class, entrada.getTipoCabo())) {
            throw new ValidacaoException("Tipo de cabo informado: " + entrada.getTipoCabo() + ". " +
                    "Valores aceitos: " + FieldUtil.listarEnums(TIPO_CABO.class) + ".",
                    ErrosSistema.MATERIAL_DO_CABO_INVALIDO);
        }

        // valida tipo de circuito
        if (entrada.getTipoCircuito() == null ||
                FieldUtil.enumContem(TIPO_CIRCUITO.class, entrada.getTipoCircuito())) {
            throw new ValidacaoException("Tipo de circuito informado: " + entrada.getTipoCircuito() + ". " +
                    "Valores aceitos: " + FieldUtil.listarEnums(TIPO_CIRCUITO.class) + ".",
                    ErrosSistema.TIPO_CIRCUITO_INVALIDO);
        }
    }
}
