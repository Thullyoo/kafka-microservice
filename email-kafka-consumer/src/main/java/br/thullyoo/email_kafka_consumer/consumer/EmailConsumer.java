package br.thullyoo.email_kafka_consumer.consumer;

import br.thullyoo.email_kafka_consumer.DTO.UserProducerDTO;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Component;

@Component
public class EmailConsumer {

    @KafkaListener(topicPartitions = @TopicPartition(topic = "email-microservice", partitions = { "0" }), containerFactory = "containerFactory")
    public void consumerUserRegisteredMessage(UserProducerDTO userProducerDTO){
        System.out.println("E-mail: " + userProducerDTO.email());
        System.out.println("Nome: " + userProducerDTO.username());
    }

}
