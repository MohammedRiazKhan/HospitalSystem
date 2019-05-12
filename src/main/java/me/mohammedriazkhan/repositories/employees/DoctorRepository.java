package me.mohammedriazkhan.repositories.employees;

import me.mohammedriazkhan.domain.employee.Doctor;
import me.mohammedriazkhan.repositories.Repository;

import java.util.Set;

public interface DoctorRepository extends Repository<Doctor, Integer> {

    Set<Doctor> getAll();

}
