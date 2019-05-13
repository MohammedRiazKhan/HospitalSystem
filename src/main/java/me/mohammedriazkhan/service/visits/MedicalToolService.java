package me.mohammedriazkhan.service.visits;

import me.mohammedriazkhan.domain.visits.MedicalTool;
import me.mohammedriazkhan.service.Service;

import java.util.Set;

public interface MedicalToolService extends Service<MedicalTool, Integer> {

    Set<MedicalTool> getAll();

}
