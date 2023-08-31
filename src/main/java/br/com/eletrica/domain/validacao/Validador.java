package br.com.eletrica.domain.validacao;

import br.com.eletrica.common.exception.ValidacaoException;
import br.com.eletrica.domain.model.api.requisicao.DadosEntrada;

import java.util.ArrayList;
import java.util.List;

public interface Validador {

    void validar(DadosEntrada entrada) throws ValidacaoException;

    static void validarRequisicaoCabeacao(DadosEntrada entrada) throws ValidacaoException {
        List<Validador> validadores = carregarValidadores();

        for (Validador validador : validadores) {
            validador.validar(entrada);
        }
    }

    private static List<Validador> carregarValidadores() {
        List<Validador> validadores = new ArrayList<>();

        validadores.add(new ValidarConstantes());
        validadores.add(new ValidarValoresNegativos());
        validadores.add(new ValidarRegrasDeCalculo());

        return validadores;
    }
}