package me.mohammedriaz.services.visits;

import me.mohammedriaz.domain.visits.Medication;
import me.mohammedriaz.services.Service;

import java.util.Set;

public interface MedicationService extends Service<Medication, Integer> {

    Set<Medication> getAll();

}
