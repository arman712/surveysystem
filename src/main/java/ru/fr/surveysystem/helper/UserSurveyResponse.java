package ru.fr.surveysystem.helper;

import lombok.Data;

import java.util.List;

@Data
public class UserSurveyResponse {

    private String surveyName;
    private String surveyDescription;
    List<AnswerResponse> answers;


}
