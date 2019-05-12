package me.mohammedriazkhan.services.employees;

import me.mohammedriazkhan.domain.employee.Porter;
import me.mohammedriazkhan.services.Service;

import java.util.Set;

public interface PorterService extends Service<Porter, Integer> {
    Set<Porter> getAll();
}
