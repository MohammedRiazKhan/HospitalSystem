package me.mohammedriazkhan.services.patients;

import me.mohammedriazkhan.domain.patients.Patient;
import me.mohammedriazkhan.services.Service;

import java.util.Set;

public interface OutPatientService extends Service<Patient, Integer> {
    Set<Patient> getAll();
}
