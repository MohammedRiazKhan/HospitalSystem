package repositories.hospital;


import domain.hospital.Department;
import repositories.Repository;

import java.util.HashSet;
import java.util.Set;

public interface DepartmentRepository extends Repository<Department, Integer> {

    Set<Department> getAll();


}
