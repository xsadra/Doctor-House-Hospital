package de.sadrab.accountancy.persistence.repository;



import de.sadrab.accountancy.persistence.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient,Long> {
    Patient save(Patient patient);
}
