package me.mohammedriaz.services.employees;

import me.mohammedriaz.domain.employee.Administration;
import me.mohammedriaz.services.Service;

import java.util.Set;

public interface AdministrationService extends Service<Administration, Integer> {

    Set<Administration> getAll();

}
