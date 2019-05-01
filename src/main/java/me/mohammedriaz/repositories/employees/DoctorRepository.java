package me.mohammedriaz.repositories.employees;

import me.mohammedriaz.domain.employee.Doctor;
import me.mohammedriaz.repositories.Repository;

import java.util.Set;

public interface DoctorRepository extends Repository<Doctor, Integer> {

    Set<Doctor> getAll();

}
