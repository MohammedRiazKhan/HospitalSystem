package me.mohammedriazkhan.domain.employee;

import javax.persistence.Entity;
import javax.sound.sampled.Port;
import java.util.Objects;

@Entity
public class Porter extends Employee{

    private String accessKeys;

    public Porter(){}

    public Porter(PorterBuilder builder){

        super(builder);
        this.accessKeys = builder.accessKeys;

    }

    public static class PorterBuilder extends Employee.Builder{

        private String accessKeys;

        public PorterBuilder(){
            super();
        }

        public PorterBuilder accessKeys(String accessKeys){
            this.accessKeys = accessKeys;
            return this;
        }

        public PorterBuilder copy(Porter porter){
            this.employeeId(porter.getEmployeeId());
            this.firstName(porter.getFirstName());
            this.lastName(porter.getLastName());
            this.identityNumber(porter.getIdentityNumber());
            this.employmentDate(porter.getEmploymentDate());
            this.jobTitle(porter.getJobTitle());

            return this;

        }

        @Override
        public Employee build() {
            return new Porter(this);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            PorterBuilder that = (PorterBuilder) o;
            return Objects.equals(accessKeys, that.accessKeys);
        }

        @Override
        public int hashCode() {
            return Objects.hash(accessKeys);
        }


    }

}
