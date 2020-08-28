package ru.pitstt.backend.producer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import ru.pitstt.Message;
import ru.pitstt.backend.consumer.ConsumerProperties;

@Slf4j
@Service
@RequiredArgsConstructor
public class Producer {

    private final ConsumerProperties consumerProperties;

    private final KafkaTemplate<Long, Message> kafkaTemplate;

    public void produce(Message message) {
        kafkaTemplate.send(consumerProperties.getResultTopic(), message.getChatId(), message);
    }
}
