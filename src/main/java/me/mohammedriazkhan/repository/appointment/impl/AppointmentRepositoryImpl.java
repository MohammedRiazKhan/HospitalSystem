package me.mohammedriazkhan.repository.appointment.impl;

import me.mohammedriazkhan.domain.appoinment.Appointment;
import me.mohammedriazkhan.repository.appointment.AppointmentRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository("AppointmentInMemory")
public class AppointmentRepositoryImpl implements AppointmentRepository {

    private static AppointmentRepositoryImpl appointmentRepository = null;
    private Set<Appointment> appointments;

    public AppointmentRepositoryImpl(){
        appointments = new HashSet<>();
    }

    public static AppointmentRepositoryImpl getAppointmentRepository() {

        if(appointmentRepository == null){
            return new AppointmentRepositoryImpl();
        }

        return appointmentRepository;
    }

    @Override
    public Appointment create(Appointment appointment) {
        appointments.add(appointment);
        return appointment;
    }

    @Override
    public Appointment read(String id) {

       return appointments.stream().filter(appointment -> appointment.getAppointmentId().equals(id)).findAny().orElse(null);

    }

    @Override
    public Appointment update(Appointment appointment) {

        Appointment inDB = read(appointment.getAppointmentId());

        if(inDB != null){
            appointments.remove(inDB);
            appointments.add(appointment);
            return appointment;
        }

        return null;
    }

    @Override
    public void delete(String id) {

        Appointment inDB = read(id);
        appointments.remove(inDB);
    }

    @Override
    public Set<Appointment> getAll() {

       return appointments;
    }



}
