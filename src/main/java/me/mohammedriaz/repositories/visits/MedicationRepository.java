package me.mohammedriaz.repositories.visits;

import me.mohammedriaz.domain.visits.Medication;
import me.mohammedriaz.repositories.Repository;

import java.util.Set;

public interface MedicationRepository extends Repository<Medication, Integer>{


    Set<Medication> getAll();

}

