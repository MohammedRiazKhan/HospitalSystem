package me.mohammedriazkhan.repositories.patients;

import me.mohammedriazkhan.domain.patients.Patient;
import me.mohammedriazkhan.repositories.Repository;

import java.util.Set;

public interface OutPatientRepository extends Repository<Patient, Integer> {


    Set<Patient> getAll();

}
