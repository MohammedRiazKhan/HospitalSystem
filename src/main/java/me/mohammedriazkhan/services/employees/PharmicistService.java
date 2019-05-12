package me.mohammedriazkhan.services.employees;

import me.mohammedriazkhan.domain.employee.Pharmacist;
import me.mohammedriazkhan.services.Service;

import java.util.Set;

public interface PharmicistService extends Service<Pharmacist, Integer> {
    Set<Pharmacist> getAll();
}
