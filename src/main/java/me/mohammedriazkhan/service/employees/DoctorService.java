package me.mohammedriazkhan.service.employees;

import me.mohammedriazkhan.domain.employee.Doctor;
import me.mohammedriazkhan.service.Service;

import java.util.Set;

public interface DoctorService extends Service<Doctor, Integer> {

    Set<Doctor> getAll();

}
