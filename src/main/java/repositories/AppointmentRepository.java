package repositories;

import domain.appoinments.Appointment;

import java.util.HashSet;
import java.util.Set;

public interface AppointmentRepository extends Repository<Appointment, Integer> {

    Set<Appointment> getAll();

}
