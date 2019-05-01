package me.mohammedriaz.repositories.patients;

import me.mohammedriaz.domain.patients.Patient;
import me.mohammedriaz.repositories.Repository;

import java.util.Set;

public interface OutPatientRepository extends Repository<Patient, Integer> {


    Set<Patient> getAll();

}
