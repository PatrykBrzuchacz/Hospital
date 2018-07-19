package pl.softsystem.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.softsystem.hospital.model.Examination;
import pl.softsystem.hospital.model.ExaminationType;

public interface ExaminationRepository extends JpaRepository<Examination, Long> {
    Long getIdByType(Examination examination);

}
