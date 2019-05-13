package me.mohammedriazkhan.service.employees;

import me.mohammedriazkhan.domain.employee.Cleaner;
import me.mohammedriazkhan.service.Service;

import java.util.Set;

public interface CleanerService extends Service<Cleaner, Integer> {

    Set<Cleaner> getAll();

}
