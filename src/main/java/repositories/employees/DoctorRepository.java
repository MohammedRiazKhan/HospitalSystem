package repositories.employees;

import domain.employee.Doctor;
import repositories.Repository;

import java.util.HashSet;
import java.util.Set;

public interface DoctorRepository extends Repository<Doctor, Integer> {

    Set<Doctor> getAll();

}
