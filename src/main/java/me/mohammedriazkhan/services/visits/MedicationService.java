package me.mohammedriazkhan.services.visits;

import me.mohammedriazkhan.domain.visits.Medication;
import me.mohammedriazkhan.services.Service;

import java.util.Set;

public interface MedicationService extends Service<Medication, Integer> {

    Set<Medication> getAll();

}
