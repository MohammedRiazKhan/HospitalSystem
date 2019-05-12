package me.mohammedriazkhan.domain.visits;

import me.mohammedriazkhan.domain.patients.Patient;
import me.mohammedriazkhan.domain.employee.Doctor;
import me.mohammedriazkhan.domain.employee.Nurse;

import java.util.List;

public class Visit {

    private int visitId;
    private String visitDate;
    private Patient patient;
    private Doctor doctor;
    private Nurse nurse;
    private List<Medication> medication;
    private List<MedicalTool> tools;


    public Visit(){

    }

    private Visit(VisitBuilder builder){
        this.visitId = builder.visitId;
        this.visitDate = builder.visitDate;
        this.patient = builder.patient;
        this.nurse = builder.nurse;
        this.medication = builder.medication;
        this.tools = builder.tools;

    }

    public int getVisitId() {
        return visitId;
    }

    public void setVisitId(int visitId) {
        this.visitId = visitId;
    }

    public String getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(String visitDate) {
        this.visitDate = visitDate;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Nurse getNurse() {
        return nurse;
    }

    public void setNurse(Nurse nurse) {
        this.nurse = nurse;
    }

    public List<Medication> getMedication() {
        return medication;
    }

    public void setMedication(List<Medication> medication) {
        this.medication = medication;
    }

    public List<MedicalTool> getTools() {
        return tools;
    }

    public void setTools(List<MedicalTool> tools) {
        this.tools = tools;
    }

    public static class VisitBuilder{
        private int visitId;
        private String visitDate;
        private Patient patient;
        private Doctor doctor;
        private Nurse nurse;
        private List<Medication> medication;
        private List<MedicalTool> tools;


        public VisitBuilder visitId(int visitId){

            this.visitId = visitId;
            return this;
        }

        public VisitBuilder visitDate(String visitDate){
            this.visitDate = visitDate;
            return this;
        }

        public VisitBuilder patient(Patient patient){
            this.patient = patient;
            return this;
        }

        public VisitBuilder doctor(Doctor doctor){
            this.doctor = doctor;
            return this;
        }

        public VisitBuilder nurse(Nurse nurse){
            this.nurse = nurse;
            return this;
        }

        public VisitBuilder medication(List<Medication> medication){
            this.medication = medication;
            return this;
        }

        public VisitBuilder tools(List<MedicalTool> tools){
            this.tools = tools;
            return this;
        }

        public Visit build(){
            return new Visit(this);
        }

        @Override
        public String toString() {
            return "VisitBuilder{" +
                    "visitId=" + visitId +
                    ", visitDate='" + visitDate + '\'' +
                    ", patient=" + patient +
                    ", doctor=" + doctor +
                    ", nurse=" + nurse +
                    ", medication=" + medication +
                    ", tools=" + tools +
                    '}';
        }
    }

}
