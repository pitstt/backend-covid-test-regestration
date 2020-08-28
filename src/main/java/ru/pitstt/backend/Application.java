package ru.pitstt.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import ru.pitstt.backend.consumer.ConsumerProperties;

@SpringBootApplication
@EnableConfigurationProperties(ConsumerProperties.class)
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
