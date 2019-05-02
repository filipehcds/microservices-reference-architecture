package br.com.microservices.customerservice.client;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class CardClientFallback implements CardClient {

	@Override
	public ResponseEntity<String> getTest() {
		return new ResponseEntity<String>("Serviço fora!", HttpStatus.OK);
	}

}