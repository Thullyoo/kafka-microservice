# API de Registro de Usuário com Kafka (Java 🚀 com Spring Boot 🍃, Apache Kafka 🛠️ e Docker 🐳)

Este é um projeto composto por dois serviços Java Spring Boot, que utilizam Kafka para comunicação. O objetivo é registrar usuários no sistema (Producer) e enviar e-mails de confirmação (Consumer). Este projeto usa Docker para orquestração de serviços.

## Arquitetura
- `Producer`: Responsável por registrar usuários no sistema e enviar mensagens para o tópico Kafka com o nome e e-mail do usuário.
- `Consumer`: Responsável por consumir mensagens do tópico Kafka e enviar e-mails de confirmação para os usuários.

## Tecnologias

- Tecnologias
- Java 21
- Spring Boot 🍃
- Apache Kafka 🛠️
- MySQL (Consumer)
- PostgreSQL (Producer)
- Docker 🐳
- JavaMailSender

## Pré-requisitos

- Java 21
- Docker

### Endpoints

- `POST /user`: Registra Usuário.

### Formato dos dados

As requisições e respostas são no formato JSON. Exemplo de como se deve passar o JSON no POST:

```json
{
  "username": joao,
  "email": "email@email.com",
  "password": "1231452a136136"
}
