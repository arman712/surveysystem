package ru.fr.surveysystem.service;

import org.springframework.stereotype.Service;
import ru.fr.surveysystem.model.Survey;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
public interface SurveyService {

    Survey add(Survey survey);
    Survey update(Survey survey);
    void delete(Long id);
    Optional<Survey> findById(Long id);
    Survey getById(Long id);
    List<Survey> getActiveSurveys();

}
