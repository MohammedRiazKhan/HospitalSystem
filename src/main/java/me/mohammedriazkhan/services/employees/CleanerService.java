package me.mohammedriazkhan.services.employees;

import me.mohammedriazkhan.domain.employee.Cleaner;
import me.mohammedriazkhan.services.Service;

import java.util.Set;

public interface CleanerService extends Service<Cleaner, Integer> {

    Set<Cleaner> getAll();

}
