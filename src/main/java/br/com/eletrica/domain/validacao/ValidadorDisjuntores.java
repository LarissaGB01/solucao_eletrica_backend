package br.com.eletrica.domain.validacao;

import br.com.eletrica.common.exception.ValidacaoException;
import br.com.eletrica.domain.model.api.requisicao.DadosEntrada;
import br.com.eletrica.domain.model.api.requisicao.DadosEntradaDisjuntores;
import br.com.eletrica.domain.validacao.disjuntores.ValidarConstantesDisjuntores;
import br.com.eletrica.domain.validacao.disjuntores.ValidarRegrasDeCalculoDisjuntores;
import br.com.eletrica.domain.validacao.disjuntores.ValidarValoresNegativosDisjuntores;

import java.util.ArrayList;
import java.util.List;

public interface ValidadorDisjuntores {

    void validar(DadosEntradaDisjuntores entrada) throws ValidacaoException;

    static void validarRequisicaoDisjuntores(DadosEntradaDisjuntores entrada) throws ValidacaoException {
        List<ValidadorDisjuntores> validadores = carregarValidadores();

        for (ValidadorDisjuntores validador : validadores) {
            validador.validar(entrada);
        }
    }

    private static List<ValidadorDisjuntores> carregarValidadores() {
        List<ValidadorDisjuntores> validadores = new ArrayList<>();

        validadores.add(new ValidarConstantesDisjuntores());
        validadores.add(new ValidarValoresNegativosDisjuntores());
        validadores.add(new ValidarRegrasDeCalculoDisjuntores());

        return validadores;
    }
}