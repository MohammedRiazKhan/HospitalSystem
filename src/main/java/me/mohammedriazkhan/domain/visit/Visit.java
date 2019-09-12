package me.mohammedriazkhan.domain.visit;

import me.mohammedriazkhan.domain.patient.Patient;
import me.mohammedriazkhan.domain.employee.Doctor;
import me.mohammedriazkhan.domain.employee.Nurse;

import java.util.List;
import java.util.Objects;

public class Visit {

    private String visitId;
    private String visitDate;
    private String patientId;
    private String doctorId;
    private String nurseId;
    private List<Medication> medication;
    private List<MedicalTool> tools;


    public Visit(){

    }

    private Visit(VisitBuilder builder){
        this.visitId = builder.visitId;
        this.visitDate = builder.visitDate;
        this.patientId = builder.patientId;
        this.doctorId = builder.doctorId;
        this.nurseId = builder.nurseId;
        this.medication = builder.medication;
        this.tools = builder.tools;

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

    public String getNurseId() {
        return nurseId;
    }

    public void setNurseId(String nurseId) {
        this.nurseId = nurseId;
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
        private String visitId;
        private String visitDate;
        private String patientId;
        private String doctorId;
        private String nurseId;
        private List<Medication> medication;
        private List<MedicalTool> tools;


        public VisitBuilder visitId(String visitId){

            this.visitId = visitId;
            return this;
        }

        public VisitBuilder visitDate(String visitDate){
            this.visitDate = visitDate;
            return this;
        }

        public VisitBuilder patientId(String patientId){
            this.patientId = patientId;
            return this;
        }

        public VisitBuilder doctorId(String doctorId){
            this.doctorId = doctorId;
            return this;
        }

        public VisitBuilder nurseId(String nurseId){
            this.nurseId = nurseId;
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
                    "visitId='" + visitId + '\'' +
                    ", visitDate='" + visitDate + '\'' +
                    ", patientId='" + patientId + '\'' +
                    ", doctorId='" + doctorId + '\'' +
                    ", nurseId='" + nurseId + '\'' +
                    ", medication=" + medication +
                    ", tools=" + tools +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            VisitBuilder that = (VisitBuilder) o;
            return Objects.equals(visitId, that.visitId) &&
                    Objects.equals(visitDate, that.visitDate) &&
                    Objects.equals(patientId, that.patientId) &&
                    Objects.equals(doctorId, that.doctorId) &&
                    Objects.equals(nurseId, that.nurseId) &&
                    Objects.equals(medication, that.medication) &&
                    Objects.equals(tools, that.tools);
        }

        @Override
        public int hashCode() {
            return Objects.hash(visitId, visitDate, patientId, doctorId, nurseId, medication, tools);
        }
    }

}
