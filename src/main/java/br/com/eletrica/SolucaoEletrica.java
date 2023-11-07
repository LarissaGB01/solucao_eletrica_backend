package br.com.eletrica;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SolucaoEletrica {

	public static void main(String... args) {
		Dotenv.configure().load();

		SpringApplication.run(SolucaoEletrica.class, args);
	}
}