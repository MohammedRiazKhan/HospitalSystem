package me.mohammedriazkhan.service.employees;

import me.mohammedriazkhan.domain.employee.Administration;
import me.mohammedriazkhan.service.Service;

import java.util.Set;

public interface AdministrationService extends Service<Administration, Integer> {

    Set<Administration> getAll();

}
