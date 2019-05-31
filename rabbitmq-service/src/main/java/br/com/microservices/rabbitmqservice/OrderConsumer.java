package br.com.microservices.rabbitmqservice;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class OrderConsumer {

	@RabbitListener(queues = { "${queue.order.name}" })
	public void receive(@Payload String fileBody) {
		System.out.println("Recebendo Mensagem!!!");
		System.out.println("Mensagem: " + fileBody);
		System.out.println("Mensagem Recebida!!!!");
	}
}