package me.mohammedriaz.services.employees;

import me.mohammedriaz.domain.employee.Porter;
import me.mohammedriaz.services.Service;

import java.util.Set;

public interface PorterService extends Service<Porter, Integer> {
    Set<Porter> getAll();
}
