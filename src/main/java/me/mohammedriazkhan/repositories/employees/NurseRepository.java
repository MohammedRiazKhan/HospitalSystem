package me.mohammedriazkhan.repositories.employees;

import me.mohammedriazkhan.domain.employee.Nurse;
import me.mohammedriazkhan.repositories.Repository;

import java.util.Set;

public interface NurseRepository extends Repository<Nurse, Integer> {

    Set<Nurse> getAll();

}
