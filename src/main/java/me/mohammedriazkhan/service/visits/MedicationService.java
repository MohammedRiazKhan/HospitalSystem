package me.mohammedriazkhan.service.visits;

import me.mohammedriazkhan.domain.visits.Medication;
import me.mohammedriazkhan.service.Service;

import java.util.Set;

public interface MedicationService extends Service<Medication, Integer> {

    Set<Medication> getAll();

}
