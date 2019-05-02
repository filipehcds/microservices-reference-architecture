package br.com.microservices.customerservice.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import br.com.microservices.customerservice.client.CardClient;
import br.com.microservices.customerservice.config.RestTemplateConfig;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/customer")
public class CustomerResource {
	
	@Autowired
	CardClient cardClient;

	@Autowired
	DiscoveryClient discoveryClient;

	@Autowired
	RestTemplate restTemplate;

	@GetMapping(path = "/test")
	public ResponseEntity<String> test() {
		return new ResponseEntity<>("Customer OK!", HttpStatus.OK);
	}

	@GetMapping(path = "/callCard")
	public ResponseEntity<String> callCard() {
//		List<ServiceInstance> cardService = discoveryClient.getInstances("card-service");
//		ServiceInstance instance = cardService.get(0);
		log.info("Calling cardService");
//		return restTemplate.getForEntity(instance.getUri() + "/card/test", String.class);
		
//		return restTemplate.getForEntity("http://card-service/card/test",	String.class);
		
		return cardClient.getTest();
	}

}