package pl.softsystem.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.softsystem.hospital.model.Result;

public interface ResultRepository extends JpaRepository<Result, Integer> {
}
