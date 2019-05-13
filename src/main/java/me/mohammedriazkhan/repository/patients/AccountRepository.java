package me.mohammedriazkhan.repository.patients;

import me.mohammedriazkhan.domain.visits.MedicalTool;
import me.mohammedriazkhan.repository.Repository;

import java.util.Set;

public interface AccountRepository extends Repository<MedicalTool, Integer> {


    Set<MedicalTool> getAll();

}
