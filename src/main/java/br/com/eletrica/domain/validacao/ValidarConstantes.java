//package br.com.eletrica.domain.validacao;
//
//import br.com.eletrica.common.constantes.*;
//import br.com.eletrica.common.exception.ErrosSistema;
//import br.com.eletrica.common.exception.ValidacaoException;
//import br.com.eletrica.domain.model.api.requisicao.DadosEntrada;
//
//public class ValidarConstantes implements Validador {
//
//    @Override
//    public void validar(DadosEntrada entrada) throws ValidacaoException {
//
//        // valida utilizacao do circuito
//        try {
//            TIPO_UTILIZACAO.valueOf(entrada.getUtilizacaoCircuito());
//        } catch (IllegalArgumentException e) {
//            throw new ValidacaoException("Valor nao aceito para utilizacao do circuito. " +
//                    "Utilize um desses: " + listarEnums(TIPO_UTILIZACAO.class) + ".",
//                    ErrosSistema.FINALIDADE_CIRCUITO_INVALIDA);
//        }
//
//        // valida fases voltagem
//        try {
//            FASES_VOLTAGEM.valueOf(entrada.getFasesVoltagem());
//        } catch (IllegalArgumentException e) {
//            throw new ValidacaoException("Valor nao aceito para fases da voltagem. " +
//                    "Utilize um desses: " + listarEnums(FASES_VOLTAGEM.class) + ".",
//                    ErrosSistema.FINALIDADE_CIRCUITO_INVALIDA);
//        }
//
//        // valida metodo de instalacao
//        try {
//            METODO_INSTALACAO.valueOf(entrada.getMetodoInstalacao());
//        } catch (IllegalArgumentException e) {
//            throw new ValidacaoException("Valor nao aceito para metodo de instalacao. " +
//                    "Utilize um desses: " + listarEnums(METODO_INSTALACAO.class) + ".",
//                    ErrosSistema.FINALIDADE_CIRCUITO_INVALIDA);
//        }
//
//        // valida tipo do cabo
//        try {
//            TIPO_CABO.valueOf(entrada.getTipoCabo());
//        } catch (IllegalArgumentException e) {
//            throw new ValidacaoException("Valor nao aceito para o tipo do cabo. " +
//                    "Utilize um desses: " + listarEnums(TIPO_CABO.class) + ".",
//                    ErrosSistema.FINALIDADE_CIRCUITO_INVALIDA);
//        }
//
//        // valida tipo de circuito
//        try {
//            TIPO_CIRCUITO.valueOf(entrada.getTipoCircuito());
//        } catch (IllegalArgumentException e) {
//            throw new ValidacaoException("Valor nao aceito para o tipo de circuito. " +
//                    "Utilize um desses: " + listarEnums(TIPO_CIRCUITO.class) + ".",
//                    ErrosSistema.FINALIDADE_CIRCUITO_INVALIDA);
//        }
//    }
//
//
//    public static <E extends Enum<E>> String listarEnums(Class<E> enumClass) {
//        var sb = new StringBuilder();
//
//        for (E enumValue : enumClass.getEnumConstants()) {
//            sb.append(enumValue.toString());
//            sb.append(", ");
//        }
//
//        var resposta = sb.toString();
//        return resposta.substring(0, resposta.length() - 2);
//    }
//}
