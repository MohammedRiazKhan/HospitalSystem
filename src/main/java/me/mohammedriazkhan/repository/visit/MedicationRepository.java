package me.mohammedriazkhan.repository.visit;

import me.mohammedriazkhan.domain.visit.Medication;
import me.mohammedriazkhan.repository.Repository;

import java.util.Set;

public interface MedicationRepository extends Repository<Medication, Integer>{


    Set<Medication> getAll();

}

