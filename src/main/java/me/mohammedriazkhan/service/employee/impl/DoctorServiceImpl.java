package me.mohammedriazkhan.service.employee.impl;

import me.mohammedriazkhan.domain.employee.Doctor;
import me.mohammedriazkhan.repository.employee.hibernate.DoctorRepositoryHibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import me.mohammedriazkhan.repository.employee.impl.DoctorRepositoryImpl;
import me.mohammedriazkhan.repository.employee.DoctorRepository;
import me.mohammedriazkhan.service.employee.DoctorService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service("DoctorServiceImpl")
public class DoctorServiceImpl implements DoctorService {

    private DoctorServiceImpl service = null;
    @Autowired
    private DoctorRepositoryHibernate repository;

    public DoctorServiceImpl() {
    }

    public DoctorServiceImpl getService(){

        if(service == null){
            return new DoctorServiceImpl();
        }
        return service;
    }

    @Override
    public Set<Doctor> getAll() {
        List<Doctor> list = (List<Doctor>) repository.findAll();

        return new HashSet<>(list);
    }

    @Override
    public Doctor create(Doctor doctor) {
        return repository.save(doctor);
    }

    @Override
    public Doctor read(String integer) {
        return repository.findById(integer).orElse(null);
    }

    @Override
    public Doctor update(Doctor doctor) {
        return repository.save(doctor);
    }

    @Override
    public void delete(String integer) {

        repository.deleteById(integer);
    }


}

