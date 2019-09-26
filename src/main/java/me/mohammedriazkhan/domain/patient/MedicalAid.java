package me.mohammedriazkhan.domain.patient;

import javax.persistence.Entity;
import java.util.Objects;

@Entity
public class MedicalAid extends Account{

    private String medicalAidNo;
    private String cover;
    private String provider;

    public MedicalAid(){}

    private MedicalAid(MedicalAidBuilder builder){

        super(builder);
        this.medicalAidNo = builder.medicalAidNo;
        this.cover = builder.cover;
        this.provider = builder.provider;

    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getMedicalAidNo() {
        return medicalAidNo;
    }

    public void setMedicalAidNo(String medicalAidNo) {
        this.medicalAidNo = medicalAidNo;
    }

    public static class MedicalAidBuilder extends Account.AccountBuilder{

        private String medicalAidNo;
        private String cover;
        private String provider;

        public MedicalAidBuilder(){
            super();
        }

        public MedicalAidBuilder medicalAidNo(String medicalAidNo){
            this.medicalAidNo = medicalAidNo;
            return this;
        }

        public MedicalAidBuilder cover(String cover){
            this.cover = cover;
            return this;
        }

        public MedicalAidBuilder provider(String provider){
            this.provider = provider;
            return this;
        }

        public MedicalAidBuilder copy( MedicalAid  medicalAid){

            this.medicalAidNo(medicalAid.getAccountId());
            this.cover(medicalAid.getCover());
            this.provider(medicalAid.getProvider());
            return this;
        }

        @Override
        public Account build() {
            return new MedicalAid(this);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            if (!super.equals(o)) return false;
            MedicalAidBuilder that = (MedicalAidBuilder) o;
            return Objects.equals(medicalAidNo, that.medicalAidNo) &&
                    Objects.equals(cover, that.cover) &&
                    Objects.equals(provider, that.provider);
        }

        @Override
        public int hashCode() {
            return Objects.hash(super.hashCode(), medicalAidNo, cover, provider);
        }

        @Override
        public String toString() {
            return "MedicalAidBuilder{" +
                    "medicalAidNo='" + medicalAidNo + '\'' +
                    ", cover='" + cover + '\'' +
                    ", provider='" + provider + '\'' +
                    "} " + super.toString();
        }
    }

}
