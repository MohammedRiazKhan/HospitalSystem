package me.mohammedriazkhan.repositories.patients;

import me.mohammedriazkhan.domain.visits.MedicalTool;
import me.mohammedriazkhan.repositories.Repository;

import java.util.Set;

public interface AccountRepository extends Repository<MedicalTool, Integer> {


    Set<MedicalTool> getAll();

}
