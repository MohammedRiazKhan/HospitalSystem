package me.mohammedriazkhan.repository.patient;

import me.mohammedriazkhan.domain.patient.Patient;
import me.mohammedriazkhan.repository.Repository;

import java.util.Set;

public interface OutPatientRepository extends Repository<Patient, String> {


    Set<Patient> getAll();

}
