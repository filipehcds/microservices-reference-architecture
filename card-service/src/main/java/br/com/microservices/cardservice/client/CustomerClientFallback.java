package br.com.microservices.cardservice.client;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class CustomerClientFallback implements CustomerClient {

	@Override
	public ResponseEntity<String> getTest() {
		return new ResponseEntity<String>("Serviço fora!", HttpStatus.OK);
	}

}