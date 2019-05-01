package me.mohammedriaz.services.appointment;

import me.mohammedriaz.domain.appoinments.Appointment;
import me.mohammedriaz.services.Service;

import java.util.Set;

public interface AppointmentService extends Service<Appointment, Integer> {

    Set<Appointment> getAll();

}
