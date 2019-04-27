package services.employees;

import domain.appoinments.Appointment;
import domain.employee.Pharmacist;
import services.Service;

import java.util.Set;

public interface PharmicistService extends Service<Pharmacist, Integer> {
    Set<Pharmacist> getAll();
}
