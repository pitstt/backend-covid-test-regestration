package ru.pitstt.backend.producer;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import ru.pitstt.backend.consumer.ConsumerProperties;

@Configuration
public class ProducerConfig {

    @Bean
    NewTopic inputTopic(ConsumerProperties consumerProperties) {
        return TopicBuilder
                .name(consumerProperties.getResultTopic())
                .partitions(consumerProperties.getThreads())
                .build();
    }
}
