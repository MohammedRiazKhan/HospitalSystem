package repositories.patients;

import domain.patients.Patient;
import repositories.Repository;

import java.util.HashSet;
import java.util.Set;

public interface PatientRepository extends Repository<Patient, Integer> {


    Set<Patient> getAll();


}

