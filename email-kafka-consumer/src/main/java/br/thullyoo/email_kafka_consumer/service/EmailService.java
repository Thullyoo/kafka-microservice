package br.thullyoo.email_kafka_consumer.service;

import br.thullyoo.email_kafka_consumer.DTO.UserProducerDTO;
import br.thullyoo.email_kafka_consumer.model.Email;
import br.thullyoo.email_kafka_consumer.model.Status;
import br.thullyoo.email_kafka_consumer.repository.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class EmailService {

    @Autowired
    private EmailRepository emailRepository;

    @Autowired
    private JavaMailSender javaMailSender;

    @Value(value = "${spring.mail.username}")
    private String emailFrom;

    public void sendEmail(Email email){
        try{
            email.setCreated_at(LocalDateTime.now());
            email.setEmailFrom(emailFrom);

            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            simpleMailMessage.setTo(email.getEmailTo());
            simpleMailMessage.setSubject(email.getSubject());
            simpleMailMessage.setText(email.getMessage());

            javaMailSender.send(simpleMailMessage);

            email.setStatus(Status.SENT);
        } catch (MailException e){
            email.setStatus(Status.FAILED);
            throw new RuntimeException("Erro ao enviar e-mail");
        } finally {
            emailRepository.save(email);
        }
    }

}
