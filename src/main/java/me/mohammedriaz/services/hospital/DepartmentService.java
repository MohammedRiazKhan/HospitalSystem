package me.mohammedriaz.services.hospital;

import me.mohammedriaz.domain.hospital.Department;
import me.mohammedriaz.services.Service;

import java.util.Set;

public interface DepartmentService extends Service<Department, Integer> {

    Set<Department> getAll();

}
