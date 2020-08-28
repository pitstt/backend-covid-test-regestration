package ru.pitstt.backend.mapper;

import org.springframework.stereotype.Component;
import ru.pitstt.backend.models.User;

@Component
public class UserMapper {

    public User toUser(ru.pitstt.User avroUser) {
        return new User(avroUser.getChatId(), avroUser.getName()
        , avroUser.getSurname(), avroUser.getPatronymic(), avroUser.getDob());
    }
}
