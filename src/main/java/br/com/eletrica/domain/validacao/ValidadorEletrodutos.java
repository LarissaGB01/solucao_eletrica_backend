package br.com.eletrica.domain.validacao;

import br.com.eletrica.common.exception.ValidacaoException;
import br.com.eletrica.domain.model.api.requisicao.DadosEntradaEletrodutos;
import br.com.eletrica.domain.validacao.eletrodutos.ValidarValoresNegativosEletrodutos;

import java.util.ArrayList;
import java.util.List;

public interface ValidadorEletrodutos {

    void validar(DadosEntradaEletrodutos entrada) throws ValidacaoException;

    static void validarRequisicao(DadosEntradaEletrodutos entrada) throws ValidacaoException {
        List<ValidadorEletrodutos> validadores = carregarValidadores();

        for (ValidadorEletrodutos validador : validadores) {
            validador.validar(entrada);
        }
    }

    private static List<ValidadorEletrodutos> carregarValidadores() {
        List<ValidadorEletrodutos> validadores = new ArrayList<>();

        validadores.add(new ValidarValoresNegativosEletrodutos());

        return validadores;
    }
}