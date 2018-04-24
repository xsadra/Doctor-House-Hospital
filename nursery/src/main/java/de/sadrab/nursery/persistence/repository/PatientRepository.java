package de.sadrab.nursery.persistence.repository;

import de.sadrab.nursery.persistence.model.Patient;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PatientRepository extends MongoRepository<Patient, String> {
    Patient save(Patient patient);
}
