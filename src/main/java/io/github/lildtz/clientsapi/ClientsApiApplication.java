package io.github.lildtz.clientsapi;

import io.github.lildtz.clientsapi.model.entity.Cliente;
import io.github.lildtz.clientsapi.model.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ClientsApiApplication {
	public static void main(String[] args) {
		SpringApplication.run(ClientsApiApplication.class, args);
	}

}
