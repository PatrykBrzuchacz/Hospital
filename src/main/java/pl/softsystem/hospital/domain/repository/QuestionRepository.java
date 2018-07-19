package pl.softsystem.hospital.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.softsystem.hospital.domain.model.Question;
@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
}