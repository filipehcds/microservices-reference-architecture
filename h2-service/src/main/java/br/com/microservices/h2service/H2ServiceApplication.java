package br.com.microservices.h2service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class H2ServiceApplication implements CommandLineRunner {

	@Autowired
	ClienteRepository clienteRepository;

	public static void main(String[] args) {
		SpringApplication.run(H2ServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		clienteRepository.deleteAll();
		clienteRepository.save(new Cliente("FilipeH2", 30, "+5511949268491"));
		clienteRepository.save(new Cliente("LeyneH2", 30, "+5511949268492"));
	}

}
