package services.employees;

import domain.appoinments.Appointment;
import domain.employee.Nurse;
import services.Service;

import java.util.Set;

public interface NurseService extends Service<Nurse, Integer> {

    Set<Nurse> getAll();

}
