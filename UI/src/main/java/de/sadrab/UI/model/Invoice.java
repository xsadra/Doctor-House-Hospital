package de.sadrab.UI.model;

import java.time.LocalDateTime;

public class Invoice {

    private Long id;
    private Double cost;
    private LocalDateTime lastTimeUsed;
    private Patient patient;

    public Invoice() {
    }

    public Invoice(Double cost, LocalDateTime lastTimeUsed, Patient patient) {
        this.cost = cost;
        this.lastTimeUsed = lastTimeUsed;
        this.patient = patient;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public LocalDateTime getLastTimeUsed() {
        return lastTimeUsed;
    }

    public void setLastTimeUsed(LocalDateTime lastTimeUsed) {
        this.lastTimeUsed = lastTimeUsed;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "id=" + id +
                ", cost=" + cost +
                ", lastTimeUsed=" + lastTimeUsed +
                ", patient=" + patient +
                '}';
    }
}
