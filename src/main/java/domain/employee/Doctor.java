package domain.employee;

import domain.patients.Patient;

import java.util.List;

public class Doctor {

    private int doctorId;
    private String firstName;
    private String lastName;
    private String title;
    private String identityNumber;
    private String specialisation;
    private List<Patient> patients;

    public Doctor() {

    }

    private Doctor(Builder builder){

        this.doctorId = builder.doctorId;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.title = builder.title;
        this.identityNumber = builder.identityNumber;
        this.specialisation = builder.specialisation;
        this.patients = builder.patients;

    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIdentityNumber() {
        return identityNumber;
    }

    public void setIdentityNumber(String identityNumber) {
        this.identityNumber = identityNumber;
    }

    public String getSpecialisation() {
        return specialisation;
    }

    public void setSpecialisation(String specialisation) {
        this.specialisation = specialisation;
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }

    public static class Builder{
        private int doctorId;
        private String firstName;
        private String lastName;
        private String title;
        private String identityNumber;
        private String specialisation;
        private List<Patient> patients;

        public Builder doctorId(int doctorId){
            this.doctorId = doctorId;
            return this;
        }


        public Builder firstName(String firstName){
            this.firstName = firstName;
            return this;
        }

        public Builder title(String title){
            this.title = title;
            return this;
        }

        public Builder lastName(String lastName){
            this.lastName = lastName;
            return this;
        }


        public Builder identityNumber(String identityNumber){
            this.identityNumber = identityNumber;
            return this;
        }


        public Builder specialisation(String specialisation){
            this.specialisation = specialisation;
            return this;
        }


        public Builder patients(List<Patient> patients){
            this.patients = patients;
            return this;
        }

        public Doctor build(){
            return new Doctor();
        }

        @Override
        public String toString() {
            return "Builder{" +
                    "doctorId=" + doctorId +
                    ", firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    ", title='" + title + '\'' +
                    ", identityNumber='" + identityNumber + '\'' +
                    ", specialisation='" + specialisation + '\'' +
                    ", patients=" + patients +
                    '}';
        }
    }
}
