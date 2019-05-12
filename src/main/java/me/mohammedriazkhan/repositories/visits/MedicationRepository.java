package me.mohammedriazkhan.repositories.visits;

import me.mohammedriazkhan.domain.visits.Medication;
import me.mohammedriazkhan.repositories.Repository;

import java.util.Set;

public interface MedicationRepository extends Repository<Medication, Integer>{


    Set<Medication> getAll();

}

