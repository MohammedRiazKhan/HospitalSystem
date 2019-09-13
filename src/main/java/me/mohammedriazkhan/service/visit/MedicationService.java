package me.mohammedriazkhan.service.visit;

import me.mohammedriazkhan.domain.visit.Medication;
import me.mohammedriazkhan.service.Service;

import java.util.Set;

public interface MedicationService extends Service<Medication, String> {

    Set<Medication> getAll();

}
