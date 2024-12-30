package br.thullyoo.user_producer_kafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@EnableKafka
@SpringBootApplication
public class UserProducerKafkaApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserProducerKafkaApplication.class, args);
	}

}
