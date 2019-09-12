package me.mohammedriazkhan.domain.patient;

import me.mohammedriazkhan.domain.employee.Doctor;

import java.util.Objects;

public abstract class Patient {

    private String patientId;
    private String firstName;
    private String lastName;
    private String telephone;
    private String identityNumber;
    private int age;
    private String doctorId;




    public Patient(){

    }

    protected Patient(Builder builder){

        this.patientId = builder.patientId;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.telephone = builder.telephone;
        this.identityNumber = builder.identityNumber;
        this.age = builder.age;
        this.doctorId = builder.doctorId;

    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
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

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctor(String doctorId) {
        this.doctorId = doctorId;
    }

    public static abstract class Builder{

        private String patientId;
        private String firstName;
        private String lastName;
        private String telephone;
        private String identityNumber;
        private int age;
        private String doctorId;

        public Builder patientId(String patientId){

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

        public Builder doctor(String doctorId){

            this.doctorId = doctorId;
            return this;
        }

        public abstract Patient build();

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Builder builder = (Builder) o;
            return age == builder.age &&
                    Objects.equals(patientId, builder.patientId) &&
                    Objects.equals(firstName, builder.firstName) &&
                    Objects.equals(lastName, builder.lastName) &&
                    Objects.equals(telephone, builder.telephone) &&
                    Objects.equals(identityNumber, builder.identityNumber) &&
                    Objects.equals(doctorId, builder.doctorId);
        }

        @Override
        public int hashCode() {
            return Objects.hash(patientId, firstName, lastName, telephone, identityNumber, age, doctorId);
        }

        @Override
        public String toString() {
            return "Builder{" +
                    "patientId='" + patientId + '\'' +
                    ", firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    ", telephone='" + telephone + '\'' +
                    ", identityNumber='" + identityNumber + '\'' +
                    ", age=" + age +
                    ", doctorId='" + doctorId + '\'' +
                    '}';
        }
    }

}
