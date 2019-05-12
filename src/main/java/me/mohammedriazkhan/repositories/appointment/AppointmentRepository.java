package me.mohammedriazkhan.repositories.appointment;

import me.mohammedriazkhan.domain.appoinments.Appointment;
import me.mohammedriazkhan.repositories.Repository;

import java.util.Set;

public interface AppointmentRepository extends Repository<Appointment, Integer> {

    Set<Appointment> getAll();

}
