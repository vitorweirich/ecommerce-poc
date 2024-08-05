package com.github.vitorweirich.catalog_manager;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.tradeshift.amqp.annotation.EnableRabbitRetryAndDlq;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class TestLinstener {

	@RabbitListener(containerFactory = "teste", queues = "${spring.rabbitmq.custom.teste.queue}")
	@EnableRabbitRetryAndDlq(event = "teste")
	public void listen(String message) {

		log.info("TestLinstener.listen - {}", message);
	}
}
