package br.com.microservices.reference.architecture.testservice.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.microservices.reference.architecture.testservice.domain.Car;
import br.com.microservices.reference.architecture.testservice.event.CarEvents;
import br.com.microservices.reference.architecture.testservice.service.CarService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Api(value = "cat", description = "the car API")
@RestController
public class CarResource {

	@Autowired
	private final CarService carService;

	CarResource(CarService carService) {
		this.carService = carService;
	}

	@ApiOperation(value = "List all the cars", nickname = "listCars", notes = "", tags = { "car" })
	@ApiResponses(value = { @ApiResponse(code = 405, message = "Invalid input") })
	@RequestMapping(path = "/cars", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
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
