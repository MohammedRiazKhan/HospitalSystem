package me.mohammedriazkhan.repository.employees;

import me.mohammedriazkhan.domain.employee.Porter;
import me.mohammedriazkhan.repository.Repository;

import java.util.Set;

public interface PorterRepository extends Repository<Porter, Integer> {

    Set<Porter> getAll();

}
