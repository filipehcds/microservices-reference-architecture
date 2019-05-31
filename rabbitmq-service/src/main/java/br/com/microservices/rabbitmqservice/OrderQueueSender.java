package br.com.microservices.rabbitmqservice;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class OrderQueueSender {

	@Autowired
	private RabbitTemplate rabbitTemplate;

	@Value("${queue.order.name}")
	private String queue;

	public void send(String order) {
		rabbitTemplate.convertAndSend(this.queue, order);
	}
}