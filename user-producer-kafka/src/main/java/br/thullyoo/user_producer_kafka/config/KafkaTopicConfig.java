package br.thullyoo.user_producer_kafka.config;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaAdmin;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaTopicConfig {

    @Value(value = "${kakfa.port}")
    private String kafkaPort;

    @Bean
    public KafkaAdmin kafkaAdmin(){

        Map<String, Object> configs = new HashMap<>();

        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaPort);

        return new KafkaAdmin(configs);
    }

    @Bean
    public NewTopic newTopic(){
        return new NewTopic("email-microservice",1, (short) 1);
    }

}
