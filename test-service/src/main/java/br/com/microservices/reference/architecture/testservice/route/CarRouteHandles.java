//package br.com.microservices.reference.architecture.testservice.route;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.http.MediaType;
//import org.springframework.stereotype.Component;
//import org.springframework.web.reactive.function.server.RequestPredicates;
//import org.springframework.web.reactive.function.server.RouterFunction;
//import org.springframework.web.reactive.function.server.RouterFunctions;
//import org.springframework.web.reactive.function.server.ServerRequest;
//import org.springframework.web.reactive.function.server.ServerResponse;
//
//import br.com.microservices.reference.architecture.testservice.domain.Car;
//import br.com.microservices.reference.architecture.testservice.event.CarEvents;
//import br.com.microservices.reference.architecture.testservice.service.CarService;
//import reactor.core.publisher.Mono;
//
//@Component
//public class CarRouteHandles {
//
//	private final CarService carService;
//
//	public CarRouteHandles(CarService carService) {
//		this.carService = carService;
//	}
//
//	@Bean
//	RouterFunction<?> routes(CarRouteHandles carRouteHandles) {
//		return RouterFunctions.route(RequestPredicates.GET("/cars"), carRouteHandles::allCars)
//				.andRoute(RequestPredicates.GET("/cars/{carId}"), carRouteHandles::carById)
//				.andRoute(RequestPredicates.GET("/cars/{carId}/events"), carRouteHandles::events);
//	}
//
//	public Mono<ServerResponse> allCars(ServerRequest serverRequest) {
//		return ServerResponse.ok().body(carService.findAll(), Car.class)
//				.doOnError(throwable -> new IllegalStateException("My godness NOOOOO!!"));
//	}
//
//	public Mono<ServerResponse> carById(ServerRequest serverRequest) {
//		String carId = serverRequest.pathVariable("carId");
//		return ServerResponse.ok().body(carService.findById(carId), Car.class)
//				.doOnError(throwable -> new IllegalStateException("oh boy... not againnn =(("));
//	}
//
//	public Mono<ServerResponse> events(ServerRequest serverRequest) {
//		String carId = serverRequest.pathVariable("carId");
//		return ServerResponse.ok().contentType(MediaType.TEXT_EVENT_STREAM)
//				.body(carService.streams(carId), CarEvents.class)
//				.doOnError(throwable -> new IllegalStateException("I give up!! "));
//	}
//
//}
