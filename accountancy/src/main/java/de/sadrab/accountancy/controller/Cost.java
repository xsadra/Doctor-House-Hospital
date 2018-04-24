package de.sadrab.accountancy.controller;


import de.sadrab.accountancy.parser.IllnessCost;
import de.sadrab.accountancy.persistence.model.Patient;
import org.springframework.stereotype.Controller;

import java.util.Map;

@Controller
public class Cost {
    private IllnessCost treatmentCost;

    public Cost(IllnessCost treatmentCost) {
        this.treatmentCost = treatmentCost;
    }

    public Double getCost(Patient patient) {
        Map<String, Double> costs = treatmentCost.getCost();

        String illnes = patient.getIllness();

        return provideCost(illnes, costs);
    }

    private Double provideCost(String illness, Map<String, Double> encyclopediaReference) {
        return encyclopediaReference.entrySet().stream()
                .filter(e -> e.getKey().contains(illness))
                .map(e -> e.getValue())
                .findFirst().orElse(00.01);
    }
}
