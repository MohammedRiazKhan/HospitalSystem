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
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            MedicalAidBuilder that = (MedicalAidBuilder) o;

            return medicalAidNo == that.medicalAidNo;

        }

        @Override
        public int hashCode() {
            return medicalAidNo;
        }

        @Override
        public Account build() {
            return new MedicalAid(this);
        }
    }

}
