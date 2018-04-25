package de.sadrab.UI.model;

import java.util.List;


public class Patient {
    private String name;
    private List<String> symptoms;

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

    @Override
    public String toString() {
        return "Patient{" +
                ", name='" + name + '\'' +
                ", symptoms=" + symptoms +
                '}';
    }
}