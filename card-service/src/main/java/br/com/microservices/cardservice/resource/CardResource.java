package br.com.microservices.cardservice.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import br.com.microservices.cardservice.client.CustomerClient;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/card")
public class CardResource {
	
	@Autowired
	CustomerClient customerClient;

	@Autowired
	DiscoveryClient discoveryClient;

	@Autowired
	RestTemplate restTemplate;

	@GetMapping(path = "/test", produces = "application/json")
	public ResponseEntity<String> test() {
		return new ResponseEntity<>("{\"test\":\"hello Filipe!\"}", HttpStatus.OK);
	}

	@GetMapping(path = "/callCustomer")
	public ResponseEntity<String> callCustomer() {
//		List<ServiceInstance> customerService = discoveryClient.getInstances("customer-service");
//		ServiceInstance instance = customerService.get(0);
		log.info("Calling customerService");
//		return restTemplate.getForEntity(instance.getUri() + "/customer/test", String.class);
		
//		return restTemplate.getForEntity("http://customer-service/customer/test",	String.class);
		
		return customerClient.getTest();
	}

}
