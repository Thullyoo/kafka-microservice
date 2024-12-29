package br.thullyoo.user_producer_kafka.controller;

import br.thullyoo.user_producer_kafka.DTO.UserRequest;
import br.thullyoo.user_producer_kafka.service.UserService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<Object> saveUser(@RequestBody UserRequest userRequest){
        userService.saveUser(userRequest);

        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

}
