package domain.employee;

import java.util.List;

public class Nurse extends Employee{

    private String type;

    public Nurse(){

    }

    private Nurse(NurseBuilder builder){
        super(builder);
        this.type = builder.type;

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

        @Override
        public String toString() {
            return "NurseBuilder{" +
                    "type='" + type + '\'' +
                    "} " + super.toString();
        }
    }


}
