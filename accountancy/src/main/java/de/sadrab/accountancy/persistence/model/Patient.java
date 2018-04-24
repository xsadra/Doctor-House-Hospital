package de.sadrab.accountancy.persistence.model;

//import org.springframework.data.annotation.Id;
import javax.persistence.Id;
import javax.persistence.*;


@Entity
public class Patient {
    @Id
    @GeneratedValue
    private Long id;
    private String patientId;
    private String name;
    private String illness;

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

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", patientId='" + patientId + '\'' +
                ", name='" + name + '\'' +
                ", illness='" + illness + '\'' +
                '}';
    }
}
