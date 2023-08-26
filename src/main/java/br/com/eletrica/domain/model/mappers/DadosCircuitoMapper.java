package br.com.eletrica.domain.model.mappers;

import br.com.eletrica.common.constantes.*;
import br.com.eletrica.domain.model.api.requisicao.DadosEntrada;
import br.com.eletrica.domain.model.api.resposta.DadosCircuito;

import java.math.BigDecimal;

public class DadosCircuitoMapper {
    public DadosCircuito toDomain(DadosEntrada entrada) {
        var dadosCircuito = new DadosCircuito();

        // dados do circuito
        dadosCircuito.setUtilizacaoCircuito(TIPO_UTILIZACAO.valueOf(entrada.getUtilizacaoCircuito()));
        dadosCircuito.setTipoCircuito(TIPO_CIRCUITO.valueOf(entrada.getTipoCircuito()));
        dadosCircuito.setMetodoInstalacao(METODO_INSTALACAO.valueOf(entrada.getMetodoInstalacao()));
        dadosCircuito.setTipoCabo(TIPO_CABO.valueOf(entrada.getTipoCabo()));
        dadosCircuito.setTemperaturaAmbiente(entrada.getTemperaturaAmbiente());
        dadosCircuito.setQuantidadeCircuitosAgrupados(entrada.getQuantidadeCircuitosAgrupados());
        dadosCircuito.setComprimentoFio(entrada.getComprimentoFio());

        // dados eletricos
        dadosCircuito.setFasesVoltagem(FASES_VOLTAGEM.valueOf(entrada.getFasesVoltagem()));
        dadosCircuito.setVoltagem(entrada.getVoltagem());
        dadosCircuito.setPotenciaAtiva(entrada.getPotenciaAtiva());
        dadosCircuito.setFatorDePotencia(entrada.getFatorDePotencia());

        return dadosCircuito;
    }
}
