package me.mohammedriazkhan.service.visit;

import me.mohammedriazkhan.domain.visit.MedicalTool;
import me.mohammedriazkhan.service.Service;

import java.util.Set;

public interface MedicalToolService extends Service<MedicalTool, String> {

    Set<MedicalTool> getAll();

}
