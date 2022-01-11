package ru.fr.surveysystem.model;

import lombok.Data;
import ru.fr.surveysystem.model.enums.QuestionType;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "question_text")
    private String questionText;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "question_type")
    private QuestionType questionType;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Choice> choices;



}
