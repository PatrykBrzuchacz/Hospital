package pl.softsystem.hospital.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.softsystem.hospital.domain.model.Examination;
import pl.softsystem.hospital.domain.model.ExaminationType;

public interface ExaminationRepository extends JpaRepository<Examination, Long> {
    Examination getExaminationByType(ExaminationType type);

}
