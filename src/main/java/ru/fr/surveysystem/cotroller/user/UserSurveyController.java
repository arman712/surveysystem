package ru.fr.surveysystem.cotroller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.fr.surveysystem.model.UserSurvey;
import ru.fr.surveysystem.service.SurveyService;
import ru.fr.surveysystem.service.UserSurveyService;

@RestController
@RequestMapping("/user/survey")
public class UserSurveyController {


    @Autowired
    private SurveyService surveyService;
    @Autowired
    private UserSurveyService userSurveyService;


    @GetMapping("/active")
    public ResponseEntity<?> getActiveSurveys() {
        return ResponseEntity.ok(surveyService.getActiveSurveys());
    }


    @PostMapping("/taking")
    public ResponseEntity<?> takeSurvey(@RequestParam(required = false) Long userId, @RequestBody UserSurvey result) {

        return ResponseEntity.ok(userSurveyService.add(result));
    }


    @GetMapping("/mySurvey/{userId}")
    public ResponseEntity<?> getMySurvey(@PathVariable Long userId){
       return ResponseEntity.ok(userSurveyService.castToResponse(userSurveyService.getByUserId(userId)));
    }

}
