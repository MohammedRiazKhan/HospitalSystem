package me.mohammedriaz.repositories.hospital;


import me.mohammedriaz.domain.hospital.Department;
import me.mohammedriaz.repositories.Repository;

import java.util.Set;

public interface DepartmentRepository extends Repository<Department, Integer> {

    Set<Department> getAll();


}
