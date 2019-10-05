package me.mohammedriazkhan.domain.visit;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Visit {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private String visitId;
    private String visitDate;
    private String patientId;
    private String doctorId;
    private String duration;
    private String patientNote;

    public Visit(){

    }

    public Visit(String visitId, String visitDate, String patientId, String doctorId, String duration, String patientNote) {
        this.visitId = visitId;
        this.visitDate = visitDate;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.duration = duration;
        this.patientNote = patientNote;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getPatientNote() {
        return patientNote;
    }

    public void setPatientNote(String patientNote) {
        this.patientNote = patientNote;
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
                Objects.equals(doctorId, visit.doctorId) &&
                Objects.equals(duration, visit.duration) &&
                Objects.equals(patientNote, visit.patientNote);
    }

    @Override
    public int hashCode() {
        return Objects.hash(visitId, visitDate, patientId, doctorId, duration, patientNote);
    }

    @Override
    public String toString() {
        return "Visit{" +
                "visitId='" + visitId + '\'' +
                ", visitDate='" + visitDate + '\'' +
                ", patientId='" + patientId + '\'' +
                ", doctorId='" + doctorId + '\'' +
                ", duration='" + duration + '\'' +
                ", patientNote='" + patientNote + '\'' +
                '}';
    }
}
