package br.thullyoo.user_producer_kafka.service;

import br.thullyoo.user_producer_kafka.DTO.UserRequest;
import br.thullyoo.user_producer_kafka.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void saveUser(UserRequest userRequest){

        userRepository.save(userRequest);

    }
}
