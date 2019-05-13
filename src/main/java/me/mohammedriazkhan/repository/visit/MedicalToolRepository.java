package me.mohammedriazkhan.repository.visit;

import me.mohammedriazkhan.domain.visit.MedicalTool;
import me.mohammedriazkhan.repository.Repository;

import java.util.Set;

public interface MedicalToolRepository extends Repository<MedicalTool, Integer> {


    Set<MedicalTool> getAll();

}
