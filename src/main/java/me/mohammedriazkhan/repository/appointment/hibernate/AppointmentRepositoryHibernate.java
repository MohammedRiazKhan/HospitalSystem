package me.mohammedriazkhan.repository.appointment.hibernate;

import me.mohammedriazkhan.domain.appoinment.Appointment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface AppointmentRepositoryHibernate extends CrudRepository<Appointment, String> {


}
