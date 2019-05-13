package me.mohammedriazkhan.service.employees;

import me.mohammedriazkhan.domain.employee.Pharmacist;
import me.mohammedriazkhan.service.Service;

import java.util.Set;

public interface PharmicistService extends Service<Pharmacist, Integer> {
    Set<Pharmacist> getAll();
}
