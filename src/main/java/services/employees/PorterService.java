package services.employees;

import domain.appoinments.Appointment;
import domain.employee.Porter;
import services.Service;

import java.util.Set;

public interface PorterService extends Service<Porter, Integer> {
    Set<Porter> getAll();
}
