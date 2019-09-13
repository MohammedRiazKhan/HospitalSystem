package me.mohammedriazkhan.repository.employee;

import me.mohammedriazkhan.domain.employee.Porter;
import me.mohammedriazkhan.repository.Repository;

import java.util.Set;

public interface PorterRepository extends Repository<Porter, String> {

    Set<Porter> getAll();

}
