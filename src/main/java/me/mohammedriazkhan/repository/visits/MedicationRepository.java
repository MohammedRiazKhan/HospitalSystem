package me.mohammedriazkhan.repository.visits;

import me.mohammedriazkhan.domain.visits.Medication;
import me.mohammedriazkhan.repository.Repository;

import java.util.Set;

public interface MedicationRepository extends Repository<Medication, Integer>{


    Set<Medication> getAll();

}

