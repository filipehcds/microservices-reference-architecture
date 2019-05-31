package br.com.microservices.securityservice;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/security")
public class SecurityServiceController {

	@RequestMapping(produces = "application/json")
	public String test() {
		return "{\"security\":\"OK\"}";
	}
	
}
