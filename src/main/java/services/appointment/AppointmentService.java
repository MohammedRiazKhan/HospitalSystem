package services.appointment;

import domain.appoinments.Appointment;
import services.Service;

import java.util.Set;

public interface AppointmentService extends Service<Appointment, Integer> {

    Set<Appointment> getAll();

}
