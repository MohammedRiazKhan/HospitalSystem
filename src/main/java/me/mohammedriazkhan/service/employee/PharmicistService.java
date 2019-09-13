package me.mohammedriazkhan.service.employee;

import me.mohammedriazkhan.domain.employee.Pharmacist;
import me.mohammedriazkhan.service.Service;

import java.util.Set;

public interface PharmicistService extends Service<Pharmacist, String> {
    Set<Pharmacist> getAll();
}
