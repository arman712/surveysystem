package ru.fr.surveysystem.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.fr.surveysystem.model.Survey;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Repository
public interface SurveyRepo extends JpaRepository<Survey,Long> {

    Survey getById(Long id);
    Optional<Survey>findById(Long id);
    List<Survey> getAllByStartTimeLessThanAndEndTimeGreaterThan(Timestamp currentTime,Timestamp currentTime1);
}
