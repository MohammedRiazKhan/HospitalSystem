package me.mohammedriazkhan.service.patient;

import me.mohammedriazkhan.domain.patient.Patient;
import me.mohammedriazkhan.service.Service;

import java.util.Set;

public interface PatientService extends Service<Patient, Integer> {
    Set<Patient> getAll();
}
