package me.mohammedriazkhan.services.appointment;

import me.mohammedriazkhan.domain.appoinments.Appointment;
import me.mohammedriazkhan.services.Service;

import java.util.Set;

public interface AppointmentService extends Service<Appointment, Integer> {

    Set<Appointment> getAll();

}
