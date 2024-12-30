package br.thullyoo.email_kafka_consumer.model;

public enum Status {
    PENDING,
    SENT,
    FAILED;

    public boolean isSent() {
        return this == SENT;
    }

    public boolean isFailed() {
        return this == FAILED;
    }
}
