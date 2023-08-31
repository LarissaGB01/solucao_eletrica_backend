package br.com.eletrica.domain.validacao;

import br.com.eletrica.common.exception.ErrosSistema;
import br.com.eletrica.common.exception.ValidacaoException;
import br.com.eletrica.domain.model.api.requisicao.DadosEntrada;

import java.math.BigDecimal;

public class ValidarValoresNegativos implements Validador {

    @Override
    public void validar(DadosEntrada entrada) {

        // valida voltagem
        if (entrada.getVoltagem() == null || entrada.getVoltagem() <= 0) {
            throw new ValidacaoException("Voltagem informada: " + entrada.getVoltagem(),
                    ErrosSistema.TENSAO_SISTEMA_INVALIDO);
        }

        // valida potencia ativa
        if (entrada.getPotenciaAtiva() != null && entrada.getPotenciaAtiva().compareTo(BigDecimal.ZERO) < 0) {
            throw new ValidacaoException("Potencia ativa informada: " + entrada.getPotenciaAtiva(),
                    ErrosSistema.POTENCIA_ATIVA_INVALIDA);
        }

        // valida potencia aparente
        if (entrada.getPotenciaAparente() != null && entrada.getPotenciaAparente().compareTo(BigDecimal.ZERO) < 0) {
            throw new ValidacaoException("Potencia aparente informada: " + entrada.getPotenciaAparente(),
                    ErrosSistema.POTENCIA_APARENTE_INVALIDA);
        }

        // valida fator de potencia
        if (entrada.getFatorDePotencia() != null
                && (entrada.getFatorDePotencia().compareTo(BigDecimal.ZERO) < 0
                || entrada.getFatorDePotencia().compareTo(BigDecimal.ONE) > 0)) {
            throw new ValidacaoException("Fator de potencia informado: " + entrada.getFatorDePotencia(),
                    ErrosSistema.FATOR_DE_POTENCIA_INVALIDO);
        }

        // valida temperatura ambiente
        if (entrada.getTemperaturaAmbiente() == null || entrada.getTemperaturaAmbiente() <= 0) {
            throw new ValidacaoException("Temperatura informada: " + entrada.getTemperaturaAmbiente(),
                    ErrosSistema.TEMPERATURA_AMBIENTE_INVALIDA);
        }

        // valida quantidade de circuitos agrupados
        if (entrada.getQuantidadeCircuitosAgrupados() == null || entrada.getQuantidadeCircuitosAgrupados() <= 0) {
            throw new ValidacaoException("Quantidade de circuitos informada: " + entrada.getQuantidadeCircuitosAgrupados(),
                    ErrosSistema.QUANTIDADE_CIRCUITOS_AGRUPAGOS_INVALIDA);
        }

        // valida comprimento do fio
        if (entrada.getComprimentoFio() == null || entrada.getComprimentoFio() <= 0) {
            throw new ValidacaoException("Comprimento informado: " + entrada.getComprimentoFio(),
                    ErrosSistema.COMPRIMENTO_CABO_INVALIDO);
        }

    }
}
