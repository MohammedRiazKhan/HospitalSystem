package me.mohammedriazkhan.services.hospital;

import me.mohammedriazkhan.domain.hospital.Department;
import me.mohammedriazkhan.services.Service;

import java.util.Set;

public interface DepartmentService extends Service<Department, Integer> {

    Set<Department> getAll();

}
