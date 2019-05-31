package br.com.microservices.configservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RefreshScope
@RestController
public class ViaCepRestController {
	
	@Autowired
	private Environment env;
	
	@Value("${endpoints.viacep}")
	private String viaCep;
	
	@Value("${endpoints.viaceprestapi}")
	private String viaCepRestAPI;

	@RequestMapping("/call")
	public String viaCepCall() {
		return viaCep + " " + viaCepRestAPI;
	}
	
}
