package me.mohammedriazkhan.domain.employee;

import java.util.Arrays;

public class Pharmacist extends Employee{

    private int[] medic;

    public Pharmacist(){

    }

    public Pharmacist(PharmacistBuilder builder){
        super(builder);
        this.medic = builder.medic;
    }

    public static class PharmacistBuilder extends Employee.Builder{

        private int[] medic;

        public PharmacistBuilder(){
            super();
        }

        public PharmacistBuilder medic(int[] medic){
            this.medic = medic;
            return this;
        }


        @Override
        public Employee build() {
            return new Pharmacist(this);
        }

        @Override
        public String toString() {
            return "PharmacistBuilder{" +
                    "medic=" + Arrays.toString(medic) +
                    "} " + super.toString();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            PharmacistBuilder that = (PharmacistBuilder) o;

            return Arrays.equals(medic, that.medic);

        }

        @Override
        public int hashCode() {
            return Arrays.hashCode(medic);
        }
    }

    public int[] getMedic() {
        return medic;
    }

    public void setMedic(int[] medic) {
        this.medic = medic;
    }
}
