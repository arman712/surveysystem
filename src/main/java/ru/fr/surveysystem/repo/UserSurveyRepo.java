package ru.fr.surveysystem.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.fr.surveysystem.model.UserSurvey;

import java.util.List;

@Repository
public interface UserSurveyRepo extends JpaRepository<UserSurvey,Long> {
    List<UserSurvey> getByUserId(Long id);
}
