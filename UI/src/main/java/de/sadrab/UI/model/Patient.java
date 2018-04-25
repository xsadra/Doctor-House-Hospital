package de.sadrab.UI.model;


public class Patient {
    private Long id;
    private String patientId;
    private String name;
    private String illness;
    private String treatment;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
                "id=" + id +
                ", patientId='" + patientId + '\'' +
                ", name='" + name + '\'' +
                ", illness='" + illness + '\'' +
                ", treatment='" + treatment + '\'' +
                '}';
    }
}
