package ru.fr.surveysystem.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.fr.surveysystem.helper.AnswerResponse;
import ru.fr.surveysystem.helper.UserSurveyResponse;
import ru.fr.surveysystem.model.Answer;
import ru.fr.surveysystem.model.Question;
import ru.fr.surveysystem.model.Survey;
import ru.fr.surveysystem.model.UserSurvey;
import ru.fr.surveysystem.repo.UserSurveyRepo;
import ru.fr.surveysystem.service.QuestionService;
import ru.fr.surveysystem.service.SurveyService;
import ru.fr.surveysystem.service.UserSurveyService;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserSurveyServiceImpl implements UserSurveyService {

    @Autowired
    private UserSurveyRepo userSurveyRepo;

    @Autowired
    private SurveyService surveyService;

    @Autowired
    private QuestionService questionService;

    @Override
    public UserSurvey add(UserSurvey userSurvey) {
        return userSurveyRepo.save(userSurvey);
    }

    @Override
    public List<UserSurveyResponse> castToResponse(List<UserSurvey> userSurveys) {
        List<UserSurveyResponse> userSurveyResponses = new ArrayList<>();
        for (UserSurvey userSurvey:userSurveys){
            Survey survey = surveyService.getById(userSurvey.getId());
            UserSurveyResponse userSurveyResponse = new UserSurveyResponse();
            userSurveyResponse.setSurveyName(survey.getName());
            userSurveyResponse.setSurveyDescription(survey.getDescription());
            List<AnswerResponse> answerResponses = new ArrayList<>();
            for (Answer answer:userSurvey.getAnswers()){
                AnswerResponse answerResponse =  new AnswerResponse();
                Question question = questionService.getById(answer.getQuestionId());
                answerResponse.setQuestion(question.getQuestionText());
                answerResponse.setType(question.getQuestionType());
                answerResponse.setAnswer(answer.getAnswer());
                answerResponses.add(answerResponse);
            }
            userSurveyResponse.setAnswers(answerResponses);
            userSurveyResponses.add(userSurveyResponse);

        }
        return userSurveyResponses;
    }

    @Override
    public List<UserSurvey> getByUserId(Long id) {
        return userSurveyRepo.getByUserId(id);
    }
}
