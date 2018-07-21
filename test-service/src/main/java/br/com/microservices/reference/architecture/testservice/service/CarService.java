package br.com.microservices.reference.architecture.testservice.service;

import java.time.Duration;
import java.util.Date;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

import br.com.microservices.reference.architecture.testservice.domain.Car;
import br.com.microservices.reference.architecture.testservice.event.CarEvents;
import br.com.microservices.reference.architecture.testservice.repository.CarRepository;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

@Slf4j
@Service
public class CarService {

	private final CarRepository carRepository;

	   CarService(CarRepository carRepository) {
	       this.carRepository = carRepository;
	   }

	   public Flux<Car> findAll () {
	       return carRepository.findAll();
	   }

	   public Mono<Car> findById(String carId) {
	       return carRepository.findById(carId);
	   }
	   
	   public Mono<Car> save(Car car) {
		   log.debug("Salvando o carro -> " + car);
	       return carRepository.insert(car);
	   }
	   
	   public Flux<CarEvents> streams(String carId) {
	       return findById(carId).flatMapMany(car -> {
	           Flux<Long> interval = Flux.interval(Duration.ofSeconds(1));
	           Flux<CarEvents> events = Flux.fromStream(
	                   Stream.generate(() -> new CarEvents(car, new Date())));
	           return Flux.zip(interval, events).map(Tuple2::getT2);
	       });
	   }

}