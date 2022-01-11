package ru.fr.surveysystem.cotroller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.fr.surveysystem.model.Question;
import ru.fr.surveysystem.model.Survey;
import ru.fr.surveysystem.service.QuestionService;
import ru.fr.surveysystem.service.SurveyService;

import java.util.Optional;

@RestController
@RequestMapping("/admin/question")
public class AdminQuestionController {

    @Autowired
    private SurveyService surveyService;
    @Autowired
    private QuestionService questionService;


    @PostMapping(value = "/add/{surveyId}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> add(@PathVariable Long surveyId, @RequestBody Question question) {
        Optional<Survey> survey = surveyService.findById(surveyId);
        if (survey.isPresent()) {
            Question created = questionService.add(question);
            survey.get().getQuestions().add(created);
            surveyService.update(survey.get());
            return ResponseEntity.ok(created);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

    }


}
