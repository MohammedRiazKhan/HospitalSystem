package factories.visits;

import domain.visits.Medication;

public class MedicationFactory {

    public static Medication getMedication(int medicationId, String medicineName, String description, int dose) {
        return (Medication) new Medication.MedicationBuilder()

                .build();
    }

}
