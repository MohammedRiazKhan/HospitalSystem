package services.hospital;

import domain.appoinments.Appointment;
import domain.hospital.Department;
import services.Service;

import java.util.Set;

public interface DepartmentService extends Service<Department, Integer> {

    Set<Department> getAll();

}
