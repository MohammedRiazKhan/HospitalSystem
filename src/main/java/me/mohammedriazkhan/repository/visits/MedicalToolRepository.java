package me.mohammedriazkhan.repository.visits;

import me.mohammedriazkhan.domain.visits.MedicalTool;
import me.mohammedriazkhan.repository.Repository;

import java.util.Set;

public interface MedicalToolRepository extends Repository<MedicalTool, Integer> {


    Set<MedicalTool> getAll();

}
