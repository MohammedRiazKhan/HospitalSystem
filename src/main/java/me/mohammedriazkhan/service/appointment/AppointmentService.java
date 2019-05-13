package me.mohammedriazkhan.service.appointment;

import me.mohammedriazkhan.domain.appoinment.Appointment;
import me.mohammedriazkhan.service.Service;

import java.util.Set;

public interface AppointmentService extends Service<Appointment, Integer> {

    Set<Appointment> getAll();

}
