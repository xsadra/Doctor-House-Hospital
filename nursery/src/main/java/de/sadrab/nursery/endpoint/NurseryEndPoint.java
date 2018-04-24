package de.sadrab.nursery.endpoint;

import de.sadrab.nursery.controller.Nurse;
import de.sadrab.nursery.persistence.model.Patient;
import de.sadrab.nursery.persistence.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/patients")
public class NurseryEndPoint {

    private PatientRepository patientRepository;

    private RestTemplate restTemplate;

    private Nurse nurse;

    @Value("${accountancy.url}")
    private String accountancyUrl;

    public NurseryEndPoint(PatientRepository patientRepository, RestTemplate restTemplate, Nurse nurse) {
        this.patientRepository = patientRepository;
        this.restTemplate = restTemplate;
        this.nurse = nurse;
    }

    @PostMapping
    Patient getPatient(@RequestBody Patient patient) {
        print(patient, "Patient: ");
        Patient cured = nurse.treatment(patient);
        print(cured,"Cured: ");
//        Patient result = restTemplate.postForObject(accountancyUrl, cured, Patient.class);
//        print(result, "Result: ");
        Patient savedPatient = patientRepository.save(cured);
        print(savedPatient, "SavedPatient: ");
        return savedPatient;
    }

    private void print(Object obj, String text) {
        System.out.printf("\n" + text + obj.toString());
    }
}
