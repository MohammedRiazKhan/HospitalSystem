package me.mohammedriazkhan.factory.visit;

import me.mohammedriazkhan.domain.visit.Medication;

public class MedicationFactory {

    public static Medication getMedication(int medicationId, String medicineName, String description, int dose) {
        return new Medication.MedicationBuilder()
                .medicationId(medicationId)
                .medicineName(medicineName)
                .description(description)
                .dose(dose)
                .build();
    }


}
