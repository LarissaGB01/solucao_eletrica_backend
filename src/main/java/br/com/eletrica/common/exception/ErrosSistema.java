package br.com.eletrica.common.exception;

public enum ErrosSistema {
    FINALIDADE_CIRCUITO_INVALIDA(100, "Finalidade do circuito informado não é aceita."),
    TIPO_CIRCUITO_INVALIDO(101, "Tipo do circuito informado não é aceito."),
    FASES_SISTEMA_INVALIDA(102, "Fase do sistema informada não é aceita."),
    TIPO_DE_INSTALACAO_INVALIDA(103, "Tipo de instalação elétrica informado não é aceito."),
    MATERIAL_DO_CABO_INVALIDO(104, "Material do cabo informado não é aceito."),

    COMPRIMENTO_CABO_INVALIDO(200, "Comprimento do cabo deve ser maior do que zero."),
    TENSAO_SISTEMA_INVALIDO(201, "Tensão no sistema deve ser maior do que zero."),
    POTENCIA_ATIVA_INVALIDA(202, "Potência ativa no sistema deve ser maior do que zero."),
    POTENCIA_REATIVA_INVALIDA(203, "Potência reativa no sistema deve ser maior do que zero."),
    FATOR_DE_POTENCIA_INVALIDO(204, "Fator de potência do sistema deve estar entre zero e um."),
    TEMPERATURA_AMBIENTE_INVALIDA(205, "Temperatura ambiente deve ser maior do que zero."),
    QUANTIDADE_CIRCUITOS_AGRUPAGOS_INVALIDA(206, "Quantidade de circuitos agrupados deve ser maior do que zero."),
    COMPRIMENTO_DO_FIO_INVALID0(207, "Comprimento do fio deve ser maior do que zero."),

    TENSAO_DIFERENTE_FASES_SISTEMA(300, "Tensão escolhida não é aceita para o sistema informado."),
    AMBAS_POTENCIAS_PREENCHIDAS(301, "Forneça apenas um valor para a potência do sistema (ativa ou reativa)."),
    POTENCIAS_REATIVA_E_FATOR_POTENCIA_PREENCHIDOS(302, "Caso preencha o valor da potência reativa, não é necessário informar o fator de potência."),
    POTENCIA_ATIVA_PREENCHIDA_E_FATOR_POTENCIA_NAO(303, "Caso preencha o valor da potência ativa, é necessário informar o fator de potência."),
    TEMPERATURA_ATINGIU_MAXIMO(304, "Temperatura informada excede o limite aceito."),

    ACESSO_BANCO_DADOS(400, "Erro ao acessar banco de dados."),
    REGISTRO_DIAMETRO_NAO_ENCONTRADO(401, "Diametro nao encontrado para os parametros informados."),
    REGISTRO_TEMPERATURA_NAO_ENCONTRADO(402, "Correcao da temperatura nao encontrada para os parametros informados.");

    private final String mensagem;
    private final Integer codigo;

    private ErrosSistema(Integer codigo, String mensagem) {
        this.mensagem = mensagem;
        this.codigo = codigo;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getMensagem() {
        return mensagem;
    }
}