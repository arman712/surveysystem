package ru.fr.surveysystem.cotroller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.fr.surveysystem.model.Survey;
import ru.fr.surveysystem.service.SurveyService;

import java.util.Optional;

@RestController
@RequestMapping("/admin/survey")
public class AdminSurveyController {

    @Autowired
    private SurveyService surveyService;


    @PostMapping(value = "/add",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> add(@RequestBody Survey survey) {

        Survey created = surveyService.add(survey);
        return ResponseEntity.ok(created);
    }


    @PostMapping(value = "/delete/{id}",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> delete(@PathVariable Long id) {

        Optional<Survey> deleted = surveyService.findById(id);
        if(deleted.isPresent()){
            surveyService.delete(id);
            return ResponseEntity.status(HttpStatus.OK).build();
        }else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }


    @PostMapping(value = "/update",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> update(@RequestBody Survey survey) {

        Optional<Survey> updated = surveyService.findById(survey.getId());
        if(updated.isPresent()){
            Survey upd = surveyService.update(survey);
            return ResponseEntity.ok(upd);
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

}
