package me.mohammedriazkhan.repositories.hospital;


import me.mohammedriazkhan.domain.hospital.Department;
import me.mohammedriazkhan.repositories.Repository;

import java.util.Set;

public interface DepartmentRepository extends Repository<Department, Integer> {

    Set<Department> getAll();


}
