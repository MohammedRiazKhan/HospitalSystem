package me.mohammedriazkhan.repositories.employees;

import me.mohammedriazkhan.domain.employee.Porter;
import me.mohammedriazkhan.repositories.Repository;

import java.util.Set;

public interface PorterRepository extends Repository<Porter, Integer> {

    Set<Porter> getAll();

}
