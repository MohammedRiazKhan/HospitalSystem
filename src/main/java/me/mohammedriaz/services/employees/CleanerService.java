package me.mohammedriaz.services.employees;

import me.mohammedriaz.domain.employee.Cleaner;
import me.mohammedriaz.services.Service;

import java.util.Set;

public interface CleanerService extends Service<Cleaner, Integer> {

    Set<Cleaner> getAll();

}
