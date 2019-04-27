package services.Impl;

import domain.appoinments.Appointment;
import repositories.appointment.AppointmentRepository;
import repositories.Impl.AppointmentRepositoryImpl;
import services.appointment.AppointmentService;

import java.util.Set;

public class AppointmentServiceImpl implements AppointmentService {

    private AppointmentServiceImpl service = null;
    private AppointmentRepository repository;

    public AppointmentServiceImpl(){
        this.repository = AppointmentRepositoryImpl.getAppointmentRepository();
    }

    public AppointmentServiceImpl getService(){
        if (service == null){
            service = new AppointmentServiceImpl();
        }
        return service;
    }

    @Override
    public Set<Appointment> getAll() {
        return this.repository.getAll();
    }

    @Override
    public Appointment create(Appointment appointment) {
        return this.repository.create(appointment);
    }

    @Override
    public Appointment read(Integer integer) {
        return this.repository.read(integer);
    }

    @Override
    public Appointment update(Appointment appointment) {
        return this.repository.update(appointment);
    }

    @Override
    public void delete(Integer integer) {

        repository.delete(integer);
    }
}
