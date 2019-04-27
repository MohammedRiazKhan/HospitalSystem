package services.employees;

import domain.appoinments.Appointment;
import domain.employee.Doctor;
import services.Service;

import java.util.Set;

public interface DoctorService extends Service<Doctor, Integer> {

    Set<Doctor> getAll();

}
