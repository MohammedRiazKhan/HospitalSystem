package me.mohammedriaz.services.visits;

import me.mohammedriaz.domain.visits.MedicalTool;
import me.mohammedriaz.services.Service;

import java.util.Set;

public interface MedicalToolService extends Service<MedicalTool, Integer> {

    Set<MedicalTool> getAll();

}
