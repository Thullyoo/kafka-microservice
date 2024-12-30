package br.thullyoo.email_kafka_consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@EnableKafka
@SpringBootApplication
public class EmailKafkaConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmailKafkaConsumerApplication.class, args);
	}

}
