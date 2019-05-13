package me.mohammedriazkhan.repository.appointment;

import me.mohammedriazkhan.domain.appoinments.Appointment;
import me.mohammedriazkhan.repository.Repository;

import java.util.Set;

public interface AppointmentRepository extends Repository<Appointment, Integer> {

    Set<Appointment> getAll();

}
