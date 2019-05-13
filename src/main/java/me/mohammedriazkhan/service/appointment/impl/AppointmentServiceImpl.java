package me.mohammedriazkhan.service.appointment.impl;

import me.mohammedriazkhan.domain.appoinment.Appointment;
import me.mohammedriazkhan.repository.appointment.AppointmentRepository;
import me.mohammedriazkhan.repository.appointment.impl.AppointmentRepositoryImpl;
import me.mohammedriazkhan.service.appointment.AppointmentService;
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
