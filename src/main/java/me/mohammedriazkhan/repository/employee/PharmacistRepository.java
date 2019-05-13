package me.mohammedriazkhan.repository.employee;

import me.mohammedriazkhan.domain.employee.Pharmacist;
import me.mohammedriazkhan.repository.Repository;

import java.util.Set;

public interface PharmacistRepository extends Repository<Pharmacist, Integer> {

    Set<Pharmacist> getAll();
}
