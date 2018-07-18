package pl.softsystem.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.softsystem.hospital.model.Question;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
}
