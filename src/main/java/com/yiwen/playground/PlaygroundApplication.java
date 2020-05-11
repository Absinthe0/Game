package com.yiwen.playground;

import com.yiwen.playground.model.CreateBattleMessage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.converter.RecordMessageConverter;
import org.springframework.kafka.support.converter.StringJsonMessageConverter;


@SpringBootApplication
public class PlaygroundApplication {

	private static final Logger logger = LoggerFactory.getLogger(PlaygroundApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(PlaygroundApplication.class, args);
	}

/*
	@KafkaListener(id = "2", topics = "topic1")
	public void listen2(CreateBattleMessage message) {
		logger.info("Received: " + message);
		System.out.println("Received: " + message);
	}
*/
}
