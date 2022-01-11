package ru.fr.surveysystem.service;

import org.springframework.stereotype.Service;
import ru.fr.surveysystem.helper.UserSurveyResponse;
import ru.fr.surveysystem.model.UserSurvey;

import java.util.List;

@Service
public interface UserSurveyService {

    UserSurvey add(UserSurvey userSurvey);
    List<UserSurveyResponse> castToResponse(List<UserSurvey> userSurveys);
    List<UserSurvey> getByUserId(Long id);
}
