package me.mohammedriazkhan.repositories.employees;

import me.mohammedriazkhan.domain.employee.Cleaner;
import me.mohammedriazkhan.repositories.Repository;

import java.util.Set;

public interface CleanerRepository extends Repository<Cleaner, Integer> {

    Set<Cleaner> getAll();


}
