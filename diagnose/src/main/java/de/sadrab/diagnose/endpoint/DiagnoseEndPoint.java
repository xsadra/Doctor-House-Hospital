package de.sadrab.diagnose.endpoint;

import de.sadrab.diagnose.controller.DrHouse;
import de.sadrab.diagnose.model.Patient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/patients")
public class DiagnoseEndPoint {

    private DrHouse drHouse;

    private RestTemplate restTemplate;

    @Value("${nursery.url}")
    private String nurseryUrl;

    public DiagnoseEndPoint(DrHouse drHouse, RestTemplate restTemplate) {
        this.drHouse = drHouse;
        this.restTemplate = restTemplate;
    }

    @PostMapping
    Patient getPatient(@RequestBody Patient patient) {
        Patient drHouseDiagnoses = drHouse.diagnose(patient);
        restTemplate.postForEntity(nurseryUrl,drHouseDiagnoses,Void.class);
        return patient;
    }
}
