package de.sadrab.nursery.controller;

import de.sadrab.nursery.parser.TreatmentEncyclopedia;
import de.sadrab.nursery.persistence.model.Patient;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class Nurse {

    private TreatmentEncyclopedia treatmentEncyclopedia;

    public Nurse(TreatmentEncyclopedia treatmentEncyclopedia) {
        this.treatmentEncyclopedia = treatmentEncyclopedia;
    }

    public Patient treatment(Patient patient) {
        Map<String, List<String>> encyclopediaReference = treatmentEncyclopedia.getTreatments();

        String patienttIllness = patient.getIllness();

        String treatment = provideTreatment(patienttIllness, encyclopediaReference);
        patient.setTreatment(treatment);

        return patient;
    }

    private String provideTreatment(String patienttIllness, Map<String, List<String>> encyclopediaReference) {
        return encyclopediaReference.entrySet().stream()
                .filter(e -> e.getKey().contains(patienttIllness))
                .map(e -> e.getValue().stream().collect(Collectors.joining(", ")))
                .findFirst().orElse("You die :D");
    }
}
