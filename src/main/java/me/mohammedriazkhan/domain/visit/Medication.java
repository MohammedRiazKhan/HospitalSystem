package me.mohammedriazkhan.domain.visit;

import java.util.Objects;

public class Medication {

    private String medicationId;
    private String medicineName;
    private String description;
    private int dose;

    public Medication(){

    }

    private Medication(MedicationBuilder builder){
        this.medicationId = builder.medicationId;
        this.medicineName = builder.medicineName;
        this.description = builder.description;
        this.dose = builder.dose;
    }

    public String getMedicationId() {
        return medicationId;
    }

    public void setMedicationId(String medicationId) {
        this.medicationId = medicationId;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDose() {
        return dose;
    }

    public void setDose(int dose) {
        this.dose = dose;
    }

    public static class MedicationBuilder{

        private String medicationId;
        private String medicineName;
        private String description;
        private int dose;

        public MedicationBuilder medicationId(String medicationId){
            this.medicationId = medicationId;
            return this;
        }

        public MedicationBuilder medicineName(String medicineName){
            this.medicineName = medicineName;
            return this;
        }

        public MedicationBuilder description(String description){
            this.description = description;
            return this;
        }

        public MedicationBuilder dose(int dose){
            this.dose = dose;
            return this;
        }

        public Medication build(){
            return new Medication(this);
        }

        @Override
        public String toString() {
            return "MedicationBuilder{" +
                    "medicationId=" + medicationId +
                    ", medicineName='" + medicineName + '\'' +
                    ", description='" + description + '\'' +
                    ", dose=" + dose +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            MedicationBuilder that = (MedicationBuilder) o;

            if (medicationId != that.medicationId) return false;
            if (dose != that.dose) return false;
            if (medicineName != null ? !medicineName.equals(that.medicineName) : that.medicineName != null)
                return false;
            return description != null ? description.equals(that.description) : that.description == null;

        }

        @Override
        public int hashCode() {
            return Objects.hash(medicationId, medicineName, description, dose);
        }
    }

}


