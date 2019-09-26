package me.mohammedriazkhan.domain.employee;

import javax.persistence.Entity;
import java.util.Arrays;
import java.util.Objects;

@Entity
public class Cleaner extends Employee{

    private String duties;

    public Cleaner(){}

    public Cleaner(CleanerBuilder builder){
        super(builder);
        this.duties = builder.duties;
    }

    public String getDuties() {
        return duties;
    }

    public void setDuties(String duties) {
        this.duties = duties;
    }

    public static class CleanerBuilder extends Employee.Builder{

        private String duties;

        public CleanerBuilder(){
            super();
        }

        public CleanerBuilder duties(String duties) {
            this.duties = duties;
            return this;
        }

        @Override
        public String toString() {
            return "CleanerBuilder{" +
                    "duties='" + duties + '\'' +
                    "} " + super.toString();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            CleanerBuilder that = (CleanerBuilder) o;
            return Objects.equals(duties, that.duties);
        }

        @Override
        public int hashCode() {
            return Objects.hash(duties);
        }

        public CleanerBuilder copy(Cleaner cleaner){

            this.employeeId(cleaner.getEmployeeId());
            this.firstName(cleaner.getFirstName());
            this.lastName(cleaner.getLastName());
            this.identityNumber(cleaner.getIdentityNumber());
            this.employmentDate(cleaner.getEmploymentDate());
            this.jobTitle(cleaner.getJobTitle());
            this.duties(cleaner.getDuties());
            return this;

        }

        @Override
        public Employee build() {
            return new Cleaner(this);
        }
    }

}
