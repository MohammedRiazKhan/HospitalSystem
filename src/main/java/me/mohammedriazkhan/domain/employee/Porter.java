package me.mohammedriazkhan.domain.employee;

import java.util.Arrays;

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
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            PorterBuilder that = (PorterBuilder) o;

            return Arrays.equals(accessKeys, that.accessKeys);

        }

        @Override
        public int hashCode() {
            return Arrays.hashCode(accessKeys);
        }

        @Override
        public String toString() {
            return super.toString();
        }
    }

}
