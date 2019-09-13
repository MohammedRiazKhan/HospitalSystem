package me.mohammedriazkhan.service.employee;

import me.mohammedriazkhan.domain.employee.Doctor;
import me.mohammedriazkhan.service.Service;

import java.util.Set;

public interface DoctorService extends Service<Doctor, String> {

    Set<Doctor> getAll();

}
