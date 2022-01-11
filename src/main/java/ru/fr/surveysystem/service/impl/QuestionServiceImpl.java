package ru.fr.surveysystem.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.fr.surveysystem.model.Question;
import ru.fr.surveysystem.repo.QuestionRepo;
import ru.fr.surveysystem.service.QuestionService;

import java.util.Optional;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionRepo questionRepo;

    @Override
    public Question add(Question question) {
        return questionRepo.save(question);
    }

    @Override
    public Question update(Question question) {
        return questionRepo.save(question);
    }

    @Override
    public void delete(Long id) {
        questionRepo.delete(questionRepo.getById(id));
    }

    @Override
    public Optional<Question> findById(Long id) {
        return questionRepo.findById(id);
    }

    @Override
    public Question getById(Long id) {
        return questionRepo.getById(id);
    }
}
