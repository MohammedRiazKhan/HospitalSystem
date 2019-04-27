package repositories.employees;

import domain.employee.Porter;
import repositories.Repository;

import java.util.HashSet;
import java.util.Set;

public interface PorterRepository extends Repository<Porter, Integer> {

    Set<Porter> getAll();

}
