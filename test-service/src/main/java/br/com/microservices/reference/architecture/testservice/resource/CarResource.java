package br.com.microservices.reference.architecture.testservice.resource;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.microservices.reference.architecture.testservice.domain.Car;
import br.com.microservices.reference.architecture.testservice.event.CarEvents;
import br.com.microservices.reference.architecture.testservice.service.CarService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class CarResource {

	   private final CarService carService;

	   CarResource(CarService carService) {
	       this.carService = carService;
	   }

	   @GetMapping("/cars")
	   public Flux<Car> all() {
	       return carService.findAll();
	   }

	   @GetMapping("/cars/{carId}")
	   public Mono<Car> byId(@PathVariable String carId) {
	       return carService.findById(carId);
	   }

	   @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE, value = "/cars/{carId}/events")
	   public Flux<CarEvents> eventsOfStreams(@PathVariable String carId) {
	       return carService.streams(carId);
	   }
	
}
