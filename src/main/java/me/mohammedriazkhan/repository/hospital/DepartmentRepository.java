package me.mohammedriazkhan.repository.hospital;


import me.mohammedriazkhan.domain.hospital.Department;
import me.mohammedriazkhan.repository.Repository;

import java.util.Set;

public interface DepartmentRepository extends Repository<Department, String> {

    Set<Department> getAll();


}
