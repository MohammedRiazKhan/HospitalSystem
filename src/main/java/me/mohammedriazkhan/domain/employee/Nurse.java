package me.mohammedriazkhan.domain.employee;

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

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            NurseBuilder that = (NurseBuilder) o;

            return type != null ? type.equals(that.type) : that.type == null;

        }

        @Override
        public int hashCode() {
            return type != null ? type.hashCode() : 0;
        }
    }


}
