package ru.fr.surveysystem.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.fr.surveysystem.model.Survey;
import ru.fr.surveysystem.repo.SurveyRepo;
import ru.fr.surveysystem.service.SurveyService;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
public class SurveyServiceImpl implements SurveyService {

    @Autowired
    private SurveyRepo surveyRepo;

    @Override
    public Survey add(Survey survey) {
        return surveyRepo.save(survey);
    }

    @Override
    public Survey update(Survey survey) {
        return surveyRepo.save(survey);
    }

    @Override
    public void delete(Long id) {
       surveyRepo.delete(surveyRepo.getById(id));
    }

    @Override
    public Optional<Survey> findById(Long id) {
        return surveyRepo.findById(id);
    }

    @Override
    public Survey getById(Long id) {
        return surveyRepo.getById(id);
    }

    @Override
    public List<Survey> getActiveSurveys() {
        Timestamp current = new Timestamp(System.currentTimeMillis());
        return surveyRepo.getAllByStartTimeLessThanAndEndTimeGreaterThan(current,current);
    }
}
