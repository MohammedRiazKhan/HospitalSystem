package me.mohammedriazkhan.service.employee;

import me.mohammedriazkhan.domain.employee.Cleaner;
import me.mohammedriazkhan.service.Service;

import java.util.Set;

public interface CleanerService extends Service<Cleaner, String> {

    Set<Cleaner> getAll();

}
