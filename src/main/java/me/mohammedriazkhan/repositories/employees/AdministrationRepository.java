package me.mohammedriazkhan.repositories.employees;

import me.mohammedriazkhan.domain.employee.Administration;
import me.mohammedriazkhan.repositories.Repository;

import java.util.Set;

public interface AdministrationRepository extends Repository<Administration, Integer> {

    Set<Administration> getAll();


}
