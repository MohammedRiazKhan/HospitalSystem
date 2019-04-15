package domain.patients;

import domain.employee.Doctor;

public class Patient {

    private int patientId;
    private String firstName;
    private String lastName;
    private String telephone;
    private String identityNumber;
    private int age;
    private Doctor doctor;

    private Patient(){

    }

    private Patient(Builder builder){

        this.patientId = builder.patientId;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.telephone = builder.telephone;
        this.identityNumber = builder.identityNumber;
        this.age = builder.age;
        this.doctor = builder.doctor;

    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
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

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getIdentityNumber() {
        return identityNumber;
    }

    public void setIdentityNumber(String identityNumber) {
        this.identityNumber = identityNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public static class Builder{

        private int patientId;
        private String firstName;
        private String lastName;
        private String telephone;
        private String identityNumber;
        private int age;
        private Doctor doctor;

        public Builder patientId(int patientId){

            this.patientId = patientId;
            return this;
        }

        public Builder firstName(String firstName){

            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName){

            this.lastName = lastName;
            return this;
        }


        public Builder telephone(String telephone){

            this.telephone = telephone;
            return this;
        }

        public Builder identityNumber(String identityNumber){

            this.identityNumber = identityNumber;
            return this;
        }

        public Builder age(int age){

            this.age = age;
            return this;
        }

        public Builder doctor(Doctor doctor){

            this.doctor = doctor;
            return this;
        }

        public Patient build(){
            return new Patient(this);
        }

        @Override
        public String toString() {
            return "Builder{" +
                    "patientId=" + patientId +
                    ", firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    ", telephone='" + telephone + '\'' +
                    ", identityNumber='" + identityNumber + '\'' +
                    ", age=" + age +
                    ", doctor=" + doctor +
                    '}';
        }
    }

}
