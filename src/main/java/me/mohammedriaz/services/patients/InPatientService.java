package me.mohammedriaz.services.patients;

import me.mohammedriaz.domain.patients.Patient;
import me.mohammedriaz.services.Service;

import java.util.Set;

public interface InPatientService extends Service<Patient, Integer> {

    Set<Patient> getAll();

}
