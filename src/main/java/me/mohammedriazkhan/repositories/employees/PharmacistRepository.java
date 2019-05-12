package me.mohammedriazkhan.repositories.employees;

import me.mohammedriazkhan.domain.employee.Pharmacist;
import me.mohammedriazkhan.repositories.Repository;

import java.util.Set;

public interface PharmacistRepository extends Repository<Pharmacist, Integer> {

    Set<Pharmacist> getAll();
}
