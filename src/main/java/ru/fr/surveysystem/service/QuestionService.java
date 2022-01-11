package ru.fr.surveysystem.service;

import org.springframework.stereotype.Service;
import ru.fr.surveysystem.model.Question;
import ru.fr.surveysystem.model.Survey;

import java.util.Optional;

@Service
public interface QuestionService {
    Question add(Question question);
    Question update(Question question);
    void delete(Long id);
    Optional<Question> findById(Long id);
    Question getById(Long id);
}
