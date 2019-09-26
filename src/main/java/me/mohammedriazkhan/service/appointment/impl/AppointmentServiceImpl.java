package me.mohammedriazkhan.service.appointment.impl;

import me.mohammedriazkhan.domain.appoinment.Appointment;
import me.mohammedriazkhan.repository.appointment.AppointmentRepository;
import me.mohammedriazkhan.repository.appointment.hibernate.AppointmentRepositoryHibernate;
import me.mohammedriazkhan.repository.appointment.impl.AppointmentRepositoryImpl;
import me.mohammedriazkhan.service.appointment.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Service("AppointmentServiceImpl")
public class AppointmentServiceImpl implements AppointmentService {

    private AppointmentServiceImpl service = null;
    @Autowired
    private AppointmentRepositoryHibernate repository;

    public AppointmentServiceImpl(){

    }

    public AppointmentServiceImpl getService(){
        if (service == null){
            service = new AppointmentServiceImpl();
        }
        return service;
    }

    @Override
    public Set<Appointment> getAll() {

        List<Appointment> list = (List<Appointment>) repository.findAll();

        return new HashSet<>(list);
    }

    @Override
    public Appointment create(Appointment appointment) {
        return this.repository.save(appointment);
    }

    @Override
    public Appointment read(String integer) {
        return this.repository.findById(integer).orElse(null);
    }

    @Override
    public Appointment update(Appointment appointment) {
        return this.repository.save(appointment);
    }

    @Override
    public void delete(String integer) {

        repository.deleteById(integer);
    }
}
