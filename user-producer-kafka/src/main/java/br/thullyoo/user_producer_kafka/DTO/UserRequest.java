package br.thullyoo.user_producer_kafka.DTO;

public record UserRequest(String username, String email, String password) {
}
