package ru.pitstt.backend.repository;

import org.springframework.data.repository.CrudRepository;
import ru.pitstt.backend.models.User;

public interface UserRepository extends CrudRepository<User, Long> {
}
