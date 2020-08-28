package ru.pitstt.backend.consumer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import ru.pitstt.Message;
import ru.pitstt.backend.mapper.UserMapper;
import ru.pitstt.backend.models.User;
import ru.pitstt.backend.producer.Producer;
import ru.pitstt.backend.repository.UserRepository;

@Slf4j
@Service
@RequiredArgsConstructor
public class Consumer {

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    private final Producer producer;

    @KafkaListener(topics = "${app.krasnodar-topic}", groupId = "krasnodar")
    public void consume(ru.pitstt.User avroUser) {
        log.info(String.format("#### -> Consumed message from krasnodarTopic -> %s", avroUser.toString()));
        User newUser = userRepository.save(userMapper.toUser(avroUser));
        producer.produce(Message.newBuilder()
                .setChatId(newUser.getChatId())
                .setText("Регистрация на тестирование успешно завершена, приходите завтра в поликлинику!")
                .build());
    }
}
