package me.mohammedriaz.services.employees;

import me.mohammedriaz.domain.employee.Pharmacist;
import me.mohammedriaz.services.Service;

import java.util.Set;

public interface PharmicistService extends Service<Pharmacist, Integer> {
    Set<Pharmacist> getAll();
}
