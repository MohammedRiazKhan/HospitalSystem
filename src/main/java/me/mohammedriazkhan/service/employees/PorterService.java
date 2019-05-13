package me.mohammedriazkhan.service.employees;

import me.mohammedriazkhan.domain.employee.Porter;
import me.mohammedriazkhan.service.Service;

import java.util.Set;

public interface PorterService extends Service<Porter, Integer> {
    Set<Porter> getAll();
}
