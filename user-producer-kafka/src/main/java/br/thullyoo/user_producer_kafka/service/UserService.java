package br.thullyoo.user_producer_kafka.service;

import br.thullyoo.user_producer_kafka.DTO.UserProducerDTO;
import br.thullyoo.user_producer_kafka.DTO.UserRequest;
import br.thullyoo.user_producer_kafka.producer.UserProducer;
import br.thullyoo.user_producer_kafka.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserProducer userProducer;

    public UserService(UserRepository userRepository, UserProducer userProducer) {
        this.userRepository = userRepository;
        this.userProducer = userProducer;
    }

    public void saveUser(UserRequest userRequest){

        userRepository.save(userRequest);

        userProducer.sendUserRegisteredNotification(new UserProducerDTO(userRequest.email(), userRequest.username()));
    }
}
