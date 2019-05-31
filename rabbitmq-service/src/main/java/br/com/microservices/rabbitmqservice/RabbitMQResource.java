package br.com.microservices.rabbitmqservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rabbitmq")
public class RabbitMQResource {

	@Autowired
	OrderQueueSender orderQueueSender;

	@RequestMapping("/send")
	public String queue() {
		System.out.println("GET /queue");
		System.out.println("Enviando Mensagem!!!!");
		orderQueueSender.send("Testeeeeeeeeeeee");
		System.out.println("Mensagem Enviada!!!!");
		return "OK";
	}

}
