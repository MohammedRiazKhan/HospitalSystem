package me.mohammedriazkhan.service.patient;

import me.mohammedriazkhan.domain.patient.Patient;
import me.mohammedriazkhan.service.Service;

import java.util.Set;

public interface OutPatientService extends Service<Patient, String> {
    Set<Patient> getAll();
}
