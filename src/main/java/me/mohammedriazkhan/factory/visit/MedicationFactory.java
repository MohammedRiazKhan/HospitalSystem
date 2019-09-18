package me.mohammedriazkhan.factory.visit;

import me.mohammedriazkhan.domain.visit.Medication;
import me.mohammedriazkhan.helper.IDGenerator;

public class MedicationFactory {

    public static Medication getMedication(String medicineName, String dose, int quantity) {
        return new Medication.MedicationBuilder()
                .medicationId(IDGenerator.generateId())
                .medicineName(medicineName)
                .dose(dose)
                .quantity(quantity)
                .build();
    }


}
