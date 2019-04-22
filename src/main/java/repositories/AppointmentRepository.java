package repositories;

import domain.appoinments.Appointment;

import java.util.HashSet;
import java.util.Set;

public class AppointmentRepository implements Repository<Appointment> {

    private static AppointmentRepository appointmentRepository = null;
    private Set<Appointment> appointments;


    public AppointmentRepository(){
        appointments = new HashSet<>();
    }


    public static AppointmentRepository getAppointmentRepository() {

        if(appointmentRepository == null){
            return new AppointmentRepository();
        }

        return appointmentRepository;
    }

    @Override
    public Appointment find(int id) {
        return appointments.stream().filter(appointment -> appointment.getAppointmentId() == id).findAny().orElse(null);
    }

    @Override
    public void create(Appointment appointment) {
        appointments.add(appointment);
    }

    @Override
    public Appointment read(final int id) {
        return find(id);
    }

    @Override
    public void update(Appointment appointment) {

        Appointment appointmentFound = find(appointment.getAppointmentId());

        if(appointments.contains(appointmentFound)){
            appointments.remove(appointmentFound);
            appointments.add(appointment);
        }
    }

    @Override
    public void delete(Appointment appointment) {

        appointments.remove(appointment);

    }

    @Override
    public Set<Appointment> getAll() {
        return appointments;
    }



}
