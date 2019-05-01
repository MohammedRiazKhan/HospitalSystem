package me.mohammedriaz.repositories.patients;

import me.mohammedriaz.domain.visits.MedicalTool;
import me.mohammedriaz.repositories.Repository;

import java.util.Set;

public interface AccountRepository extends Repository<MedicalTool, Integer> {


    Set<MedicalTool> getAll();

}
