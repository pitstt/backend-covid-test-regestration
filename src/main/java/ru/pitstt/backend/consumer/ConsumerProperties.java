package ru.pitstt.backend.consumer;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

@Data
@Validated
@ConstructorBinding
@ConfigurationProperties(prefix = "app")
public class ConsumerProperties {

    @NotBlank
    private final String moscowTopic;

    @NotBlank
    private final String krasnodarTopic;

    @NotBlank
    private final String resultTopic;

    @Positive
    private final Integer threads;

}
