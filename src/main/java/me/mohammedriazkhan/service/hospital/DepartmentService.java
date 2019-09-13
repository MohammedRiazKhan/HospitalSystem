package me.mohammedriazkhan.service.hospital;

import me.mohammedriazkhan.domain.hospital.Department;
import me.mohammedriazkhan.service.Service;

import java.util.Set;

public interface DepartmentService extends Service<Department, String> {

    Set<Department> getAll();

}
