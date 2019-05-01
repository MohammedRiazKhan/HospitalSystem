package me.mohammedriaz.domain.employee;

public class Porter extends Employee{

    private int[] accessKeys;

    public Porter(){

    }

    public Porter(PorterBuilder builder){

        super(builder);
        this.accessKeys = builder.accessKeys;

    }

    public int[] getAccessKeys() {
        return accessKeys;
    }

    public void setAccessKeys(int[] accessKeys) {
        this.accessKeys = accessKeys;
    }


    public static class PorterBuilder extends Employee.Builder{

        private int[] accessKeys;

        public PorterBuilder(){
            super();
        }

        public PorterBuilder accessKeys(int[] accessKeys){
            this.accessKeys = accessKeys;
            return this;
        }

        @Override
        public Employee build() {
            return new Porter(this);
        }

        @Override
        public String toString() {
            return super.toString();
        }
    }

}
