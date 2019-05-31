package br.com.microservices.brinksservice;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/brinks")
public class BrinksController {
	
	@RequestMapping(produces = "application/json")
	public String teste() {
		return "{\"teste\":\"Brinks! :)\"}";
	}

}
