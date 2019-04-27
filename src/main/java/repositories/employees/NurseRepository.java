package repositories.employees;

import domain.employee.Nurse;
import repositories.Repository;

import java.util.HashSet;
import java.util.Set;

public interface NurseRepository extends Repository<Nurse, Integer> {

    Set<Nurse> getAll();

}
