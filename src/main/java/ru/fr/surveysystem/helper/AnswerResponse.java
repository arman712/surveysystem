package ru.fr.surveysystem.helper;

import lombok.Data;
import ru.fr.surveysystem.model.enums.QuestionType;

@Data
public class AnswerResponse {

    private String question;
    private QuestionType type;
    private String answer;
}
