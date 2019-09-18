package me.mohammedriazkhan.domain.employee;

import javax.persistence.Entity;
import java.util.Objects;

@Entity
public class Doctor extends Employee{

    private String specialisation;

    public Doctor(){}

    protected Doctor(DoctorBuilder builder) {
        super(builder);
        this.specialisation = builder.specialisation;

    }

    public String getSpecialisation() {
        return specialisation;
    }

    public void setSpecialisation(String specialisation) {
        this.specialisation = specialisation;
    }


    public static class DoctorBuilder extends Employee.Builder{

        private String specialisation;

        public DoctorBuilder(){
            super();
        }


        public DoctorBuilder specialisation(String specialisation){
            this.specialisation = specialisation;
            return this;
        }

        public DoctorBuilder copy(Doctor doctor){

            this.employeeId(doctor.getEmployeeId());
            this.firstName(doctor.getFirstName());
            this.lastName(doctor.getLastName());
            this.identityNumber(doctor.getIdentityNumber());
            this.employmentDate(doctor.getEmploymentDate());
            this.jobTitle(doctor.getJobTitle());
            this.specialisation(doctor.getSpecialisation());
            return this;

        }


        @Override
        public Employee build(){

            return new Doctor(this);

        }

        @Override
        public String toString() {
            return "DoctorBuilder{" +
                    "specialisation='" + specialisation +
                    "} " + super.toString();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            DoctorBuilder that = (DoctorBuilder) o;
            return Objects.equals(specialisation, that.specialisation);
        }

        @Override
        public int hashCode() {
            return Objects.hash(specialisation);
        }
    }
}
