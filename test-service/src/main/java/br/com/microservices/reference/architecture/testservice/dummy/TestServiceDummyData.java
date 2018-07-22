package br.com.microservices.reference.architecture.testservice.dummy;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import br.com.microservices.reference.architecture.testservice.domain.Car;
import br.com.microservices.reference.architecture.testservice.repository.CarRepository;
import reactor.core.publisher.Flux;

@Component
public class TestServiceDummyData implements CommandLineRunner {

	@Autowired
	private final CarRepository carRepository;

	TestServiceDummyData(CarRepository carRepository) {
	     this.carRepository = carRepository;
	  }

	@Override
	public void run(String... args) throws Exception {
		carRepository.deleteAll()
				.thenMany(Flux
						.just("Koenigsegg One:1", "Hennessy Venom GT", "Bugatti Veyron Super Sport",
								"SSC Ultimate Aero", "McLaren F1", "Pagani Huayra", "Noble M600", "Aston Martin One-77",
								"Ferrari LaFerrari", "Lamborghini Aventador")
						.map(model -> new Car(UUID.randomUUID().toString(), model)).flatMap(carRepository::save))
				.subscribe(System.out::println);
	}

}
