package services.patients;

import domain.appoinments.Appointment;
import domain.patients.Patient;
import services.Service;

import java.util.Set;

public interface InPatientService extends Service<Patient, Integer> {

    Set<Patient> getAll();

}
