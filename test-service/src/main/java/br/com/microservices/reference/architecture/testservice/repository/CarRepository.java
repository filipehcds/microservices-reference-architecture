package br.com.microservices.reference.architecture.testservice.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import br.com.microservices.reference.architecture.testservice.domain.Car;

@Repository
public interface CarRepository extends ReactiveMongoRepository<Car, String> { }