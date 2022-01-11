package ru.fr.surveysystem.model;

import lombok.Data;
import ru.fr.surveysystem.model.enums.QuestionType;

import javax.persistence.*;

@Data
@Entity
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "question_id")
    private Long questionId;

    @Column(name = "answer")
    private String answer;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "question_type")
    private QuestionType questionType;
}
