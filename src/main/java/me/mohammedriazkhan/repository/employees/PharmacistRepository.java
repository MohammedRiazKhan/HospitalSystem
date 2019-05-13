package me.mohammedriazkhan.repository.employees;

import me.mohammedriazkhan.domain.employee.Pharmacist;
import me.mohammedriazkhan.repository.Repository;

import java.util.Set;

public interface PharmacistRepository extends Repository<Pharmacist, Integer> {

    Set<Pharmacist> getAll();
}
