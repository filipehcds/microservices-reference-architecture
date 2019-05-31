package br.com.microservices.securityserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SecurityServerApplication implements CommandLineRunner {

	@Autowired
	UsuarioRepository usuarioRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(SecurityServerApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		usuarioRepository.deleteAll();
		usuarioRepository.save(new Usuario("FilipeH2", "123321"));
		usuarioRepository.save(new Usuario("LeyneH2", "123456"));
	}

}
