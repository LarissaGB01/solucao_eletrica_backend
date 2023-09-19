package br.com.eletrica.common.config;

import br.com.eletrica.domain.model.mappers.DadosCircuitoMapper;
import br.com.eletrica.infra.mapper.ConducaoCabosMapper;
import br.com.eletrica.infra.mapper.ExemplosCabosMapper;
import br.com.eletrica.infra.mapper.ExemplosDisjuntoresMapper;
import br.com.eletrica.infra.mapper.ExemplosEletrodutosMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@Configuration
public class ConfiguracaoSpring {

    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        return objectMapper;
    }

    @Bean
    public DadosCircuitoMapper dadosCircuitoMapper() {
        return new DadosCircuitoMapper();
    }

    @Bean
    public ConducaoCabosMapper conducaoCabosMapper() {
        return new ConducaoCabosMapper();
    }

    @Bean
    public ExemplosCabosMapper exemplosCabosMapper() {
        return new ExemplosCabosMapper();
    }

    @Bean
    public ExemplosDisjuntoresMapper exemplosDisjuntoresMapper() {
        return new ExemplosDisjuntoresMapper();
    }

    @Bean
    public ExemplosEletrodutosMapper exemplosEletrodutosMapper() {
        return new ExemplosEletrodutosMapper();
    }
}
