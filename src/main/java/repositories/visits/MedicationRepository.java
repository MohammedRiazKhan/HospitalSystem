package repositories.visits;

import domain.visits.Medication;
import repositories.Repository;

import java.util.HashSet;
import java.util.Set;

public interface MedicationRepository extends Repository<Medication, Integer>{


    Set<Medication> getAll();

}

