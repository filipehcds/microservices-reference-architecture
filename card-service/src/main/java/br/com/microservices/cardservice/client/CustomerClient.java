package br.com.microservices.cardservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.microservices.cardservice.config.FeignConfiguration;

@FeignClient(name = "customer-service", configuration = FeignConfiguration.class, fallback = CustomerClientFallback.class)
public interface CustomerClient {

	@RequestMapping(value = "/customer/test", method = RequestMethod.GET)
	ResponseEntity<String> getTest();

}