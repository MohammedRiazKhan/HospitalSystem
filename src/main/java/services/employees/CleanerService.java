package services.employees;

import domain.appoinments.Appointment;
import domain.employee.Cleaner;
import services.Service;

import java.util.Set;

public interface CleanerService extends Service<Cleaner, Integer> {

    Set<Cleaner> getAll();

}
