package br.thullyoo.email_kafka_consumer.repository;

import br.thullyoo.email_kafka_consumer.model.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailRepository extends JpaRepository<Email, Long> {
}
