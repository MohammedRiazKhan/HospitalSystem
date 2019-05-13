package me.mohammedriazkhan.factory.visit;

import me.mohammedriazkhan.domain.visit.Medication;

public class MedicationFactory {

    public static Medication getMedication(int medicationId, String medicineName, String description, int dose) {
        return (Medication) new Medication.MedicationBuilder()

                .build();
    }

}
