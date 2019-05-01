package me.mohammedriaz.services.employees;

import me.mohammedriaz.domain.employee.Doctor;
import me.mohammedriaz.services.Service;

import java.util.Set;

public interface DoctorService extends Service<Doctor, Integer> {

    Set<Doctor> getAll();

}
