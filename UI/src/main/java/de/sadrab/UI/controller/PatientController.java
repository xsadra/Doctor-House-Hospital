package de.sadrab.UI.controller;

import de.sadrab.UI.model.LocalPatient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PatientController {

    @Value("${admission.url}")
    private String admissionUrl;

    private RestTemplate restTemplate;

    public PatientController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void addNewPatient(LocalPatient localPatient) {
        System.out.println(localPatient);
        System.out.println(admissionUrl);
        restTemplate.postForObject(admissionUrl, localPatient, LocalPatient.class);
    }
}
