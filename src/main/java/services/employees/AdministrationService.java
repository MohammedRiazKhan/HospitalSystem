package services.employees;

import domain.appoinments.Appointment;
import domain.employee.Administration;
import services.Service;

import java.util.Set;

public interface AdministrationService extends Service<Administration, Integer> {

    Set<Administration> getAll();

}
