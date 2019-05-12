package me.mohammedriazkhan.services.employees;

import me.mohammedriazkhan.domain.employee.Administration;
import me.mohammedriazkhan.services.Service;

import java.util.Set;

public interface AdministrationService extends Service<Administration, Integer> {

    Set<Administration> getAll();

}
