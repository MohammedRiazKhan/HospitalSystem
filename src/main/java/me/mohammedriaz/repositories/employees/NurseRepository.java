package me.mohammedriaz.repositories.employees;

import me.mohammedriaz.domain.employee.Nurse;
import me.mohammedriaz.repositories.Repository;

import java.util.Set;

public interface NurseRepository extends Repository<Nurse, Integer> {

    Set<Nurse> getAll();

}
