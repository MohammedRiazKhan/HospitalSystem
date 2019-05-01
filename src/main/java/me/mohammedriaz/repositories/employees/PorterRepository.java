package me.mohammedriaz.repositories.employees;

import me.mohammedriaz.domain.employee.Porter;
import me.mohammedriaz.repositories.Repository;

import java.util.Set;

public interface PorterRepository extends Repository<Porter, Integer> {

    Set<Porter> getAll();

}
