package me.mohammedriazkhan.factory.visit;

import me.mohammedriazkhan.domain.visit.Medication;
import me.mohammedriazkhan.helper.IDGenerator;

public class MedicationFactory {

    public static Medication getMedication(String medicineName, String description, int dose) {
        return new Medication.MedicationBuilder()
                .medicationId(IDGenerator.generateId())
                .medicineName(medicineName)
                .description(description)
                .dose(dose)
                .build();
    }


}
