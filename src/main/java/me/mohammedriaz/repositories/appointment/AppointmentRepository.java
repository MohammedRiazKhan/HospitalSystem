package me.mohammedriaz.repositories.appointment;

import me.mohammedriaz.domain.appoinments.Appointment;
import me.mohammedriaz.repositories.Repository;

import java.util.Set;

public interface AppointmentRepository extends Repository<Appointment, Integer> {

    Set<Appointment> getAll();

}
