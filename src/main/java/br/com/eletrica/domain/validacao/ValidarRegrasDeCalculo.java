package br.com.eletrica.domain.validacao;

import br.com.eletrica.common.exception.ErrosSistema;
import br.com.eletrica.common.exception.ValidacaoException;
import br.com.eletrica.common.util.FieldUtil;
import br.com.eletrica.domain.model.api.requisicao.DadosEntrada;

public class ValidarRegrasDeCalculo implements Validador {

    @Override
    public void validar(DadosEntrada entrada) {

        // TENSAO_DIFERENTE_FASES_SISTEMA - Tensão escolhida não é aceita para o sistema informado.

        if (FieldUtil.campoPreenchido(entrada.getPotenciaAparente())
                && FieldUtil.campoPreenchido(entrada.getPotenciaAtiva())) {
            throw new ValidacaoException("Potencia ativa informada: " + entrada.getPotenciaAtiva() +
                    " // Potencia aparente informada: " + entrada.getPotenciaAparente(),
                    ErrosSistema.AMBAS_POTENCIAS_PREENCHIDAS);
        }

        if (!FieldUtil.campoPreenchido(entrada.getPotenciaAparente())
                && !FieldUtil.campoPreenchido(entrada.getPotenciaAtiva())) {
            throw new ValidacaoException("Potencia ativa informada: " + entrada.getPotenciaAtiva() +
                    " // Potencia aparente informada: " + entrada.getPotenciaAparente(),
                    ErrosSistema.NENHUMA_POTENCIA_PREENCHIDA);
        }

        if (FieldUtil.campoPreenchido(entrada.getPotenciaAparente())
                && FieldUtil.campoPreenchido(entrada.getFatorDePotencia())) {
            throw new ValidacaoException("Fator de potencia informado: " + entrada.getFatorDePotencia() +
                    " // Potencia aparente informada: " + entrada.getPotenciaAparente(),
                    ErrosSistema.POTENCIAS_APARENTE_E_FATOR_POTENCIA_PREENCHIDOS);
        }

        if (FieldUtil.campoPreenchido(entrada.getPotenciaAtiva())
                && !FieldUtil.campoPreenchido(entrada.getFatorDePotencia())) {
            throw new ValidacaoException("Fator de potencia informado: " + entrada.getFatorDePotencia() +
                    " // Potencia ativa informada: " + entrada.getPotenciaAtiva(),
                    ErrosSistema.POTENCIA_ATIVA_PREENCHIDA_E_FATOR_POTENCIA_NAO);
        }
    }
}
