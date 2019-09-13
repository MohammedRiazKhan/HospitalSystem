package me.mohammedriazkhan.repository.employee;

import me.mohammedriazkhan.domain.employee.Administration;
import me.mohammedriazkhan.repository.Repository;

import java.util.Set;

public interface AdministrationRepository extends Repository<Administration, String> {

    Set<Administration> getAll();


}
