package br.com.microservices.reference.architecture.testservice.event;

import java.util.Date;

import br.com.microservices.reference.architecture.testservice.domain.Car;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarEvents {

	private Car model;
	private Date when;

}