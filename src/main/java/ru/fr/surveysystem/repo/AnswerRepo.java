package ru.fr.surveysystem.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.fr.surveysystem.model.Answer;

@Repository
public interface AnswerRepo extends JpaRepository<Answer,Long> {
}
