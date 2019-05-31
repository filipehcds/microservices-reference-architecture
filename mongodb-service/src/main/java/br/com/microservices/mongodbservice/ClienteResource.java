package br.com.microservices.mongodbservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clientes")
public class ClienteResource {
	
	@Autowired
	ClienteRepository clienteRepository;
	
	@RequestMapping(produces = "application/json")
	public String ok() {
		System.out.println("GET /ok(");
		return "{\"status\":\"OK\"}";
	}

	@RequestMapping(path = "/listAll", produces = "application/json")
	public List<Cliente> listAll() {
		System.out.println("GET /listAll");
		return (List<Cliente>) clienteRepository.findAll();
	}
	
	@RequestMapping(path = "/count", produces = "application/json")
	public String count() {
		System.out.println("GET /count");
		return "{\"quantidadeDeRegistros\": " + clienteRepository.count() + "}";
	}

}
