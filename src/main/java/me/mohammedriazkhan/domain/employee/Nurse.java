package me.mohammedriazkhan.domain.employee;

import java.util.Objects;

public class Nurse extends Employee{

    private String type;

    public Nurse(){}

    private Nurse(NurseBuilder builder){
        super(builder);
        this.type = builder.type;

    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public static class NurseBuilder extends Employee.Builder{

        private String type;

        public NurseBuilder(){
            super();
        }

        public NurseBuilder type(String type){
            this.type = type;
            return this;
        }

        @Override
        public Employee build(){
            return new Nurse(this);
        }

        public NurseBuilder copy(Nurse nurse){

            this.employeeId(nurse.getEmployeeId());
            this.firstName(nurse.getFirstName());
            this.lastName(nurse.getLastName());
            this.identityNumber(nurse.getIdentityNumber());
            this.employmentDate(nurse.getEmploymentDate());
            this.jobTitle(nurse.getJobTitle());
            this.type(nurse.getType());
            return this;

        }

        @Override
        public String toString() {
            return "NurseBuilder{" +
                    "type='" + type + '\'' +
                    "} " + super.toString();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            NurseBuilder that = (NurseBuilder) o;
            return Objects.equals(type, that.type);
        }

        @Override
        public int hashCode() {
            return Objects.hash(type);
        }
    }


}
