package br.thullyoo.user_producer_kafka.repository;

import br.thullyoo.user_producer_kafka.DTO.UserRequest;
import br.thullyoo.user_producer_kafka.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

    @Autowired
    private JdbcClient jdbcClient;

    public void save(UserRequest userRequest){
        jdbcClient.sql("""
                INSERT INTO USERS (username, email, password)
                VALUES (:username, :email, :password);
                """)
                .param("username", userRequest.username())
                .param("email", userRequest.email())
                .param("password", userRequest.password())
                .update();
    }

}
