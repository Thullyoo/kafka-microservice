package br.thullyoo.email_kafka_consumer.consumer;

import br.thullyoo.email_kafka_consumer.DTO.UserProducerDTO;
import br.thullyoo.email_kafka_consumer.model.Email;
import br.thullyoo.email_kafka_consumer.model.Status;
import br.thullyoo.email_kafka_consumer.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Component;

@Component
public class EmailConsumer {

    @Autowired
    private EmailService emailService;

    @KafkaListener(topicPartitions = @TopicPartition(topic = "email-microservice", partitions = { "0" }), containerFactory = "containerFactory")
    public void consumerUserRegisteredMessage(UserProducerDTO userProducerDTO){
        Email email = new Email();
        email.setEmailTo(userProducerDTO.email());
        email.setMessage("Olá " + userProducerDTO.username() + ",\n\n"
                + "Seu registro foi realizado com sucesso! Estamos felizes em tê-lo conosco.\n"
                + "Agora você pode aproveitar todos os recursos da nossa plataforma.\n\n"
                + "Se você tiver qualquer dúvida ou precisar de ajuda, não hesite em nos contatar.\n\n"
                + "Atenciosamente,\n"
                + "A Equipe [Testes Brasil]");
        email.setStatus(Status.PENDING);
        email.setSubject("Usuário cadastrado com sucesso!");
        emailService.sendEmail(email);
    }

}
