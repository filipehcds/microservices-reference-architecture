package br.com.microservices.reference.architecture.testservice.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import br.com.microservices.reference.architecture.testservice.domain.Car;

public interface CarRepository extends ReactiveMongoRepository<Car, String> { }