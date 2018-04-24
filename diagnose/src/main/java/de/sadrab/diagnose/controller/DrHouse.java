package de.sadrab.diagnose.controller;

import de.sadrab.diagnose.model.Patient;
import de.sadrab.diagnose.parser.IllnessParser;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Map;

@Controller
public class DrHouse {

    private IllnessParser illnessParser;

    public DrHouse(IllnessParser illnessParser) {
        this.illnessParser = illnessParser;
    }

    public Patient diagnose(Patient patient) {
        Map<String, List<String>> illnessesReference = illnessParser.getIllnesses();

        List<String> patientSymptoms = patient.getSymptoms();

        String illness = determineIllness(illnessesReference, patientSymptoms);
        patient.setIllness(illness);

        return patient;
    }

    private String determineIllness(Map<String, List<String>> illnessesReference, List<String> patientSymptoms) {
         return illnessesReference.entrySet().stream()
                .filter(e->e.getValue().containsAll(patientSymptoms)&&e.getValue().size()==patientSymptoms.size())
                .map(e->e.getKey())
                .findFirst().orElse("lupus");
    }
}
