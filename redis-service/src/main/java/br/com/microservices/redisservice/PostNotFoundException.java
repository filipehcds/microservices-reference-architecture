package br.com.microservices.redisservice;

public class PostNotFoundException extends Exception {
    public PostNotFoundException(String message) {
        super(message);
    }
}
