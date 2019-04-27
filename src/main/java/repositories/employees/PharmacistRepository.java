package repositories.employees;

import domain.employee.Pharmacist;
import repositories.Repository;

import java.util.HashSet;
import java.util.Set;

public interface PharmacistRepository extends Repository<Pharmacist, Integer> {

    Set<Pharmacist> getAll();
}
