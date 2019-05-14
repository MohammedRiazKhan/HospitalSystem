package me.mohammedriazkhan.repository.appointment.impl;

import me.mohammedriazkhan.domain.appoinment.Appointment;
import me.mohammedriazkhan.repository.appointment.AppointmentRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository("InMemory")
public class AppointmentRepositoryImpl implements AppointmentRepository {

    private static AppointmentRepositoryImpl appointmentRepository = null;
    private Map<Integer, Appointment> appointments;

    public AppointmentRepositoryImpl(){
        appointments = new HashMap<>();
    }

    public static AppointmentRepositoryImpl getAppointmentRepository() {

        if(appointmentRepository == null){
            return new AppointmentRepositoryImpl();
        }

        return appointmentRepository;
    }

    /*
    Implementation using Set as data storage
    public Appointment find(int id) {
        return appointments.stream().filter(appointment -> appointment.getAppointmentId() == id).findAny().orElse(null);
    }*/

    @Override
    public Appointment create(Appointment appointment) {
        this.appointments.put(appointment.getAppointmentId(), appointment);
        return appointment;
    }

    @Override
    public Appointment read(Integer id) {

       return this.appointments.get(id);

    }

    @Override
    public Appointment update(Appointment appointment) {

       this.appointments.replace(appointment.getAppointmentId(), appointment);
       return this.appointments.get(appointment.getAppointmentId());
    }

    @Override
    public void delete(Integer id) {

        appointments.remove(id);

    }

    @Override
    public Set<Appointment> getAll() {

        //return a set to eliminate any duplicates
        Collection<Appointment> students = this.appointments.values();

        return new HashSet<>(students);
    }



}
