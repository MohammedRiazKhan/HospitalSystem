package me.mohammedriazkhan.domain.employee;

import javax.persistence.Entity;
import java.util.Arrays;
import java.util.Objects;

@Entity
public class Pharmacist extends Employee{

    private String licence;

    public Pharmacist(){}

    public String getLicence() {
        return licence;
    }

    public void setLicence(String licence) {
        this.licence = licence;
    }

    public Pharmacist(PharmacistBuilder builder){
        super(builder);
        this.licence = builder.licence;
    }

    public static class PharmacistBuilder extends Employee.Builder{

        private String licence;

        public PharmacistBuilder(){
            super();
        }

        public PharmacistBuilder licence(String licence){
            this.licence = licence;
            return this;
        }

        public PharmacistBuilder copy(Pharmacist pharmacist){
            this.employeeId(pharmacist.getEmployeeId());
            this.firstName(pharmacist.getFirstName());
            this.lastName(pharmacist.getLastName());
            this.identityNumber(pharmacist.getIdentityNumber());
            this.employmentDate(pharmacist.getEmploymentDate());
            this.jobTitle(pharmacist.getJobTitle());
            this.licence(pharmacist.getLicence());
            return this;

        }


        @Override
        public Employee build() {
            return new Pharmacist(this);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            PharmacistBuilder that = (PharmacistBuilder) o;
            return Objects.equals(licence, that.licence);
        }

        @Override
        public int hashCode() {
            return Objects.hash(licence);
        }
    }

}
