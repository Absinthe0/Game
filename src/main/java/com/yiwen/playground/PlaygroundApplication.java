package com.yiwen.playground;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@SpringBootApplication
public class PlaygroundApplication {

	private static final Logger logger = LoggerFactory.getLogger(PlaygroundApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(PlaygroundApplication.class, args);
	}

}
