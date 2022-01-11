package ru.fr.surveysystem.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.fr.surveysystem.model.Question;
@Repository
public interface QuestionRepo extends JpaRepository<Question,Long> {

    Question getById(Long id);
}
