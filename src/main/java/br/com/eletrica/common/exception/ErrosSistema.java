package br.com.eletrica.common.exception;

import org.springframework.http.HttpStatus;

public enum ErrosSistema {
    FINALIDADE_CIRCUITO_INVALIDA(100, "Finalidade do circuito informado não é aceita.", HttpStatus.BAD_REQUEST),
    TIPO_CIRCUITO_INVALIDO(101, "Tipo do circuito informado não é aceito.", HttpStatus.BAD_REQUEST),
    FASES_SISTEMA_INVALIDA(102, "Fase do sistema informada não é aceita.", HttpStatus.BAD_REQUEST),
    TIPO_DE_INSTALACAO_INVALIDA(103, "Tipo de instalação elétrica informado não é aceito.", HttpStatus.BAD_REQUEST),
    MATERIAL_DO_CABO_INVALIDO(104, "Material do cabo informado não é aceito.", HttpStatus.BAD_REQUEST),

    COMPRIMENTO_CABO_INVALIDO(200, "Comprimento do fio deve ser maior do que zero.", HttpStatus.BAD_REQUEST),
    TENSAO_SISTEMA_INVALIDO(201, "Tensão no sistema deve ser maior do que zero.", HttpStatus.BAD_REQUEST),
    POTENCIA_ATIVA_INVALIDA(202, "Potência ativa no sistema deve ser maior ou igual a zero.", HttpStatus.BAD_REQUEST),
    POTENCIA_APARENTE_INVALIDA(203, "Potência aparente no sistema deve ser maior ou igual a zero.", HttpStatus.BAD_REQUEST),
    FATOR_DE_POTENCIA_INVALIDO(204, "Fator de potência do sistema deve estar entre zero e um.", HttpStatus.BAD_REQUEST),
    TEMPERATURA_AMBIENTE_INVALIDA(205, "Temperatura ambiente deve ser maior do que zero.", HttpStatus.BAD_REQUEST),
    CORRENTE_PROJETO_INVALIDA(206, "Corrente do projeto deve ser maior do que zero.", HttpStatus.BAD_REQUEST),
    CORRENTE_MAXIMA_CABO_INVALIDA(207, "Corrente maxima do cabo deve ser maior do que zero.", HttpStatus.BAD_REQUEST),

    QUANTIDADE_CIRCUITOS_AGRUPAGOS_INVALIDA(206, "Quantidade de circuitos agrupados deve ser maior do que zero.", HttpStatus.BAD_REQUEST),

    TENSAO_DIFERENTE_FASES_SISTEMA(300, "Tensão escolhida não é aceita para o sistema informado.", HttpStatus.UNPROCESSABLE_ENTITY),
    AMBAS_POTENCIAS_PREENCHIDAS(301, "Forneça apenas um valor para a potência do sistema (ativa ou aparente).", HttpStatus.UNPROCESSABLE_ENTITY),
    POTENCIAS_APARENTE_E_FATOR_POTENCIA_PREENCHIDOS(302, "Caso preencha o valor da potência APARENTE, não é necessário informar o fator de potência.", HttpStatus.UNPROCESSABLE_ENTITY),
    POTENCIA_ATIVA_PREENCHIDA_E_FATOR_POTENCIA_NAO(303, "Caso preencha o valor da potência ativa, é necessário informar o fator de potência.", HttpStatus.UNPROCESSABLE_ENTITY),
    NENHUMA_POTENCIA_PREENCHIDA(304, "Forneça ao menos um valor para a potência do sistema (ativa ou aparente).", HttpStatus.UNPROCESSABLE_ENTITY),
    CORRENTES_INFORMADAS_INVALIDAS(305, "A corrente maxima suportada pelo cabo deve ser superior a corrente que circula no seu projeto.", HttpStatus.UNPROCESSABLE_ENTITY),

    ACESSO_BANCO_DADOS(400, "Erro ao acessar banco de dados.", HttpStatus.INTERNAL_SERVER_ERROR),
    REGISTRO_DIAMETRO_NAO_ENCONTRADO(401, "Diametro nao encontrado para os parametros informados.", HttpStatus.INTERNAL_SERVER_ERROR),
    REGISTRO_TEMPERATURA_NAO_ENCONTRADO(402, "Correcao da temperatura nao encontrada para os parametros informados.", HttpStatus.INTERNAL_SERVER_ERROR);

    private final String mensagem;
    private final Integer codigo;
    private final HttpStatus statusHttp;

    ErrosSistema(Integer codigo, String mensagem, HttpStatus statusHttp) {
        this.mensagem = mensagem;
        this.codigo = codigo;
        this.statusHttp = statusHttp;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public HttpStatus getHttpStatus() {
        return statusHttp;
    }
}