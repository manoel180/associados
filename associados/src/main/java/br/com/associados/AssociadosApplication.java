package br.com.associados;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = { "br.com.associados.entities" })
@EnableJpaRepositories(basePackages = { "br.com.associados.repository" })
public class AssociadosApplication {

	public static void main(String[] args) {
		SpringApplication.run(AssociadosApplication.class, args);
	}
}
