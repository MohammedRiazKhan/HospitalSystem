package repositories.employees;

import domain.employee.Administration;
import domain.employee.Cleaner;
import repositories.Repository;

import java.util.HashSet;
import java.util.Set;

public interface AdministrationRepository extends Repository<Administration, Integer> {

    Set<Administration> getAll();


}
