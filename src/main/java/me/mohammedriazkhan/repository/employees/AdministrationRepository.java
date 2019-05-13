package me.mohammedriazkhan.repository.employees;

import me.mohammedriazkhan.domain.employee.Administration;
import me.mohammedriazkhan.repository.Repository;

import java.util.Set;

public interface AdministrationRepository extends Repository<Administration, Integer> {

    Set<Administration> getAll();


}
