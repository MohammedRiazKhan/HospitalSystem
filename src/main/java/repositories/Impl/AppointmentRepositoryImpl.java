package repositories.Impl;

import domain.appoinments.Appointment;
import repositories.appointment.AppointmentRepository;

import java.util.HashSet;
import java.util.Set;

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

    public Appointment find(int id) {
        return appointments.stream().filter(appointment -> appointment.getAppointmentId() == id).findAny().orElse(null);
    }

    @Override
    public Appointment create(Appointment appointment) {
        appointments.add(appointment);
        return appointment;
    }

    @Override
    public Appointment read(Integer id) {

        Appointment appointment = find(id);

        if(appointment == null){
            return null;
        }
        else {
            return appointment;
        }

    }

    @Override
    public Appointment update(Appointment appointment) {

        Appointment appointmentFound = find(appointment.getAppointmentId());

        if(appointments.contains(appointmentFound)){
            appointments.remove(appointmentFound);
            appointments.add(appointment);
        }
        return appointmentFound;
    }

    @Override
    public void delete(Integer id) {

        Appointment appointment = find(id);

        appointments.remove(appointment);

    }

    @Override
    public Set<Appointment> getAll() {
        return appointments;
    }



}
