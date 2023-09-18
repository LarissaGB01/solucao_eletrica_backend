package br.com.eletrica;

import br.com.eletrica.domain.model.mappers.DadosCircuitoMapper;
import br.com.eletrica.infra.mapper.ConducaoCabosMapper;
import br.com.eletrica.infra.mapper.ExemplosCabosMapper;
import br.com.eletrica.infra.mapper.ExemplosDisjuntoresMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SolucaoEletrica {

	public static void main(String... args) {
		SpringApplication.run(SolucaoEletrica.class, args);
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
}