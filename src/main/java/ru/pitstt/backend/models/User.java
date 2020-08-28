package ru.pitstt.backend.models;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "chat_id")
    private Long chatId;

    private String name;

    private String surname;

    private String patronymic;

    private String dob;

    public User(Long chatId, String name, String surname, String patronymic, String dob) {
        this.chatId=chatId;
        this.name=name;
        this.surname=surname;
        this.patronymic=patronymic;
        this.dob=dob;
    }
}
