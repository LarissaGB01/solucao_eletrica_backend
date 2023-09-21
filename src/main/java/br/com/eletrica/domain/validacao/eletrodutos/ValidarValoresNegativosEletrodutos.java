package br.com.eletrica.domain.validacao.eletrodutos;

import br.com.eletrica.common.exception.ErrosSistema;
import br.com.eletrica.common.exception.ValidacaoException;
import br.com.eletrica.domain.model.api.requisicao.DadosEntradaEletrodutos;
import br.com.eletrica.domain.validacao.ValidadorEletrodutos;

import java.math.BigDecimal;

public class ValidarValoresNegativosEletrodutos implements ValidadorEletrodutos {

    @Override
    public void validar(DadosEntradaEletrodutos entrada) {

        // valida diametro cabo
        if (entrada.getSecaoNominalCabo() == null || entrada.getSecaoNominalCabo().compareTo(BigDecimal.ZERO) <= 0) {
            throw new ValidacaoException("Diametro do cabo informado: " + entrada.getSecaoNominalCabo(),
                    ErrosSistema.DIAMETRO_CABO_INVALIDO);
        }

        // valida quantidade condutores
        if (entrada.getQuantidadeCondutores() == null || entrada.getQuantidadeCondutores() <= 0) {
            throw new ValidacaoException("Quantidade de condutores informada: " + entrada.getQuantidadeCondutores(),
                    ErrosSistema.QUANTIDADE_CONDUTORES_INVALIDA);
        }
    }
}
