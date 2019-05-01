package me.mohammedriaz.domain.employee;

import com.fasterxml.jackson.annotation.JsonProperty;
import me.mohammedriaz.domain.patients.Patient;

import java.util.List;

public class Doctor extends Employee{

    @JsonProperty("specialisation")
    private String specialisation;
    private List<Patient> patients;

    public Doctor(){

    }

    protected Doctor(DoctorBuilder builder) {
        super(builder);
        this.patients = builder.patients;
        this.specialisation = builder.specialisation;

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

    public static class DoctorBuilder extends Employee.Builder{

        @JsonProperty("specialisation")
        private String specialisation;
        private List<Patient> patients;

        public DoctorBuilder(){
            super();
        }


        public DoctorBuilder specialisation(String specialisation){
            this.specialisation = specialisation;
            return this;
        }

        public DoctorBuilder patients(List<Patient> patients){
            this.patients = patients;
            return this;
        }

        @Override
        public Employee build(){

            return new Doctor(this);

        }

        @Override
        public String toString() {
            return "DoctorBuilder{" +
                    "specialisation='" + specialisation + '\'' +
                    ", patients=" + patients +
                    "} " + super.toString();
        }
    }
}
