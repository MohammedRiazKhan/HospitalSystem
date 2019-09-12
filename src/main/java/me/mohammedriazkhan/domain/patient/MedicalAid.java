package me.mohammedriazkhan.domain.patient;

import java.util.Objects;

public class MedicalAid extends Account{

    private String medicalAidNo;

    public MedicalAid(){

    }

    private MedicalAid(MedicalAidBuilder builder){

        super(builder);
        this.medicalAidNo = builder.medicalAidNo;

    }

    public String getMedicalAidNo() {
        return medicalAidNo;
    }

    public void setMedicalAidNo(String medicalAidNo) {
        this.medicalAidNo = medicalAidNo;
    }

    public static class MedicalAidBuilder extends Account.AccountBuilder{

        private String medicalAidNo;

        public MedicalAidBuilder(){
            super();
        }

        private MedicalAidBuilder medicalAidNo(String medicalAidNo){
            this.medicalAidNo = medicalAidNo;
            return this;
        }


        @Override
        public String toString() {
            return "MedicalAidBuilder{" +
                    "medicalAidNo=" + medicalAidNo +
                    "} " + super.toString();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            if (!super.equals(o)) return false;
            MedicalAidBuilder that = (MedicalAidBuilder) o;
            return Objects.equals(medicalAidNo, that.medicalAidNo);
        }

        @Override
        public int hashCode() {
            return Objects.hash(super.hashCode(), medicalAidNo);
        }

        @Override
        public Account build() {
            return new MedicalAid(this);
        }
    }

}
