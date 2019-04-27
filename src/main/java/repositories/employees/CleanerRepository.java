package repositories.employees;

import domain.employee.Cleaner;
import repositories.Repository;

import java.util.HashSet;
import java.util.Set;

public interface CleanerRepository extends Repository<Cleaner, Integer> {

    Set<Cleaner> getAll();


}
