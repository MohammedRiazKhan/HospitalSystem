package me.mohammedriazkhan.repositories.visits;

import me.mohammedriazkhan.domain.visits.MedicalTool;
import me.mohammedriazkhan.repositories.Repository;

import java.util.Set;

public interface MedicalToolRepository extends Repository<MedicalTool, Integer> {


    Set<MedicalTool> getAll();

}
