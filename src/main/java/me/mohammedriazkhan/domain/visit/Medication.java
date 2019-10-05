package me.mohammedriazkhan.domain.visit;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Medication {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private String medicationId;
    private String medicineName;
    private String dose;
    private int quantity;

    public Medication(){}

    private Medication(MedicationBuilder builder){
        this.medicationId = builder.medicationId;
        this.medicineName = builder.medicineName;
        this.dose = builder.dose;
        this.quantity = builder.quantity;
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

    public String getDose() {
        return dose;
    }

    public void setDose(String dose) {
        this.dose = dose;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public static class MedicationBuilder {

        private String medicationId;
        private String medicineName;
        private String dose;
        private int quantity;

        public MedicationBuilder medicationId(String medicationId) {
            this.medicationId = medicationId;
            return this;
        }

        public MedicationBuilder medicineName(String medicineName) {
            this.medicineName = medicineName;
            return this;
        }

        public MedicationBuilder dose(String dose) {
            this.dose = dose;
            return this;
        }

        public MedicationBuilder quantity(int quantity) {
            this.quantity = quantity;
            return this;
        }

        public MedicationBuilder copy(Medication medication){

            this.medicationId(medication.medicationId);
            this.medicineName(medication.getMedicineName());
            this.dose(medication.getDose());
            this.quantity(medication.getQuantity());
            return this;

        }

        public Medication build() {
            return new Medication(this);
        }

    }

}


