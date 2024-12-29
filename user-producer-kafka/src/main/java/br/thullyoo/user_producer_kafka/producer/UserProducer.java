package br.thullyoo.user_producer_kafka.producer;

import br.thullyoo.user_producer_kafka.DTO.UserProducerDTO;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class UserProducer {

    private final KafkaTemplate<String, UserProducerDTO> kafkaTemplate;

    public UserProducer(KafkaTemplate<String, UserProducerDTO> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendUserRegisteredNotification(UserProducerDTO userProducerDTO){
        kafkaTemplate.send("email-microservice", 1, null, userProducerDTO);
    }
}
