package services.visits;

import domain.appoinments.Appointment;
import domain.visits.Medication;
import services.Service;

import java.util.Set;

public interface MedicationService extends Service<Medication, Integer> {

    Set<Medication> getAll();

}
