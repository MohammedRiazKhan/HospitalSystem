package me.mohammedriaz.repositories.employees;

import me.mohammedriaz.domain.employee.Administration;
import me.mohammedriaz.repositories.Repository;

import java.util.Set;

public interface AdministrationRepository extends Repository<Administration, Integer> {

    Set<Administration> getAll();


}
