package me.mohammedriaz.repositories.employees;

import me.mohammedriaz.domain.employee.Pharmacist;
import me.mohammedriaz.repositories.Repository;

import java.util.Set;

public interface PharmacistRepository extends Repository<Pharmacist, Integer> {

    Set<Pharmacist> getAll();
}
