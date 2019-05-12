package me.mohammedriazkhan.services.visits;

import me.mohammedriazkhan.domain.visits.MedicalTool;
import me.mohammedriazkhan.services.Service;

import java.util.Set;

public interface MedicalToolService extends Service<MedicalTool, Integer> {

    Set<MedicalTool> getAll();

}
