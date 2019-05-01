package me.mohammedriaz.repositories.visits;

import me.mohammedriaz.domain.visits.MedicalTool;
import me.mohammedriaz.repositories.Repository;

import java.util.Set;

public interface MedicalToolRepository extends Repository<MedicalTool, Integer> {


    Set<MedicalTool> getAll();

}
