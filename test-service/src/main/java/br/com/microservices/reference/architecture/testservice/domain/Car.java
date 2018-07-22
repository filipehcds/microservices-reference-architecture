package br.com.microservices.reference.architecture.testservice.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@XmlRootElement(name = "car")
@XmlAccessorType(XmlAccessType.FIELD)
@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car {

	@Id
	private String id;
	private String model;

}