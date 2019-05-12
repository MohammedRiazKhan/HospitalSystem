package me.mohammedriazkhan.services.employees;

import me.mohammedriazkhan.domain.employee.Doctor;
import me.mohammedriazkhan.services.Service;

import java.util.Set;

public interface DoctorService extends Service<Doctor, Integer> {

    Set<Doctor> getAll();

}
