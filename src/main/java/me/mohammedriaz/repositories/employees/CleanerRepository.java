package me.mohammedriaz.repositories.employees;

import me.mohammedriaz.domain.employee.Cleaner;
import me.mohammedriaz.repositories.Repository;

import java.util.Set;

public interface CleanerRepository extends Repository<Cleaner, Integer> {

    Set<Cleaner> getAll();


}
