package me.mohammedriazkhan.domain.visit;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;
import java.util.Objects;

@Entity
public class Visit {

    @Id
    private String visitId;
    private String visitDate;
    private String patientId;
    private String doctorId;

    public Visit(){

    }

    public Visit(String visitId, String visitDate, String patientId, String doctorId) {
        this.visitId = visitId;
        this.visitDate = visitDate;
        this.patientId = patientId;
        this.doctorId = doctorId;
    }

    public String getVisitId() {
        return visitId;
    }

    public void setVisitId(String visitId) {
        this.visitId = visitId;
    }

    public String getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(String visitDate) {
        this.visitDate = visitDate;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Visit visit = (Visit) o;
        return Objects.equals(visitId, visit.visitId) &&
                Objects.equals(visitDate, visit.visitDate) &&
                Objects.equals(patientId, visit.patientId) &&
                Objects.equals(doctorId, visit.doctorId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(visitId, visitDate, patientId, doctorId);
    }

    @Override
    public String toString() {
        return "Visit{" +
                "visitId='" + visitId + '\'' +
                ", visitDate='" + visitDate + '\'' +
                ", patientId='" + patientId + '\'' +
                ", doctorId='" + doctorId + '\'' +
                 +
                '}';
    }
}
