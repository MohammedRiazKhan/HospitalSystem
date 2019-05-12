package me.mohammedriazkhan.services.Impl;

import me.mohammedriazkhan.domain.appoinments.Appointment;
import me.mohammedriazkhan.repositories.appointment.AppointmentRepository;
import me.mohammedriazkhan.repositories.Impl.AppointmentRepositoryImpl;
import me.mohammedriazkhan.services.appointment.AppointmentService;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
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
