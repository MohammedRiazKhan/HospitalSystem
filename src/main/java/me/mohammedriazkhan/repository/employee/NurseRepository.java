package me.mohammedriazkhan.repository.employee;

import me.mohammedriazkhan.domain.employee.Nurse;
import me.mohammedriazkhan.repository.Repository;

import java.util.Set;

public interface NurseRepository extends Repository<Nurse, Integer> {

    Set<Nurse> getAll();

}
