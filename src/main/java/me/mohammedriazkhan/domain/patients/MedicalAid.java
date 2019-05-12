package me.mohammedriazkhan.domain.patients;

public class MedicalAid extends Account{

    private int medicalAidNo;

    public MedicalAid(){

    }

    private MedicalAid(MedicalAidBuilder builder){

        super(builder);
        this.medicalAidNo = builder.medicalAidNo;

    }

    public int getMedicalAidNo() {
        return medicalAidNo;
    }

    public void setMedicalAidNo(int medicalAidNo) {
        this.medicalAidNo = medicalAidNo;
    }

    public static class MedicalAidBuilder extends Account.AccountBuilder{

        private int medicalAidNo;

        private MedicalAidBuilder medicalAidNo(int medicalAidNo){
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
        public Account build() {
            return new MedicalAid(this);
        }
    }

}
