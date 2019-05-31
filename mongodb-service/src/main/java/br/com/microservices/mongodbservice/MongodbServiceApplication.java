package br.com.microservices.mongodbservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MongodbServiceApplication implements CommandLineRunner {
	
	@Autowired
	ClienteRepository clienteRepository;

	public static void main(String[] args) {
		SpringApplication.run(MongodbServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		clienteRepository.deleteAll();
		clienteRepository.save(new Cliente("Filipe", 30, "+5511949268491"));
		clienteRepository.save(new Cliente("Leyne", 30, "+5511949268492"));
	}

}
