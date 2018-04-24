package de.sadrab.nursery.persistence.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class Patient {
    @Id
    private String id;
    private String patientId;
    private String name;
    private List<String> symptoms;
    private String illness;
    private String treatment;

    public Patient() {
    }

    public Patient(String id, String patientId, String name, List<String> symptoms, String illness, String treatment) {
        this.id = id;
        this.patientId = patientId;
        this.name = name;
        this.symptoms = symptoms;
        this.illness = illness;
        this.treatment = treatment;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(List<String> symptoms) {
        this.symptoms = symptoms;
    }

    public String getIllness() {
        return illness;
    }

    public void setIllness(String illness) {
        this.illness = illness;
    }

    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id='" + id + '\'' +
                ", patientId='" + patientId + '\'' +
                ", name='" + name + '\'' +
                ", symptoms=" + symptoms +
                ", illness='" + illness + '\'' +
                ", treatment='" + treatment + '\'' +
                '}';
    }
}
