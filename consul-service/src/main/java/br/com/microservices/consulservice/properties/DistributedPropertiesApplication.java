package br.com.microservices.consulservice.properties;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DistributedPropertiesApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(DistributedPropertiesApplication.class).run(args);
    }

}
