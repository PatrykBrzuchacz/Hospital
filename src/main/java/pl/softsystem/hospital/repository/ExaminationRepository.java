package pl.softsystem.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.softsystem.hospital.model.Examination;

public interface ExaminationRepository extends JpaRepository<Examination, Integer> {
}
