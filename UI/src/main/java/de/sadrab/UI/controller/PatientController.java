package de.sadrab.UI.controller;

import de.sadrab.UI.model.Patient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class PatientController {

    @Value("${admission.url}")
    private String admissionUrl;

    private RestTemplate restTemplate;

    public PatientController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void addNewPatient(Patient patient) {
        restTemplate.postForObject(admissionUrl, patient, Patient.class);
    }
}
