package repositories.appointment;

import domain.appoinments.Appointment;
import repositories.Repository;

import java.util.HashSet;
import java.util.Set;

public interface AppointmentRepository extends Repository<Appointment, Integer> {

    Set<Appointment> getAll();

}
