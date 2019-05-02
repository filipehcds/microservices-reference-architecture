package br.com.microservices.customerservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.microservices.customerservice.config.FeignConfiguration;

@FeignClient(name = "card-service", configuration = FeignConfiguration.class, fallback = CardClientFallback.class)
public interface CardClient {

	@RequestMapping(value = "/card/test", method = RequestMethod.GET)
	ResponseEntity<String> getTest();

}