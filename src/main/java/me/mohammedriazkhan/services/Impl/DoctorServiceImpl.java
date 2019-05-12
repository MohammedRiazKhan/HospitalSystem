package me.mohammedriazkhan.services.Impl;

import me.mohammedriazkhan.domain.employee.Doctor;
import org.springframework.stereotype.Service;
import me.mohammedriazkhan.repositories.Impl.DoctorRepositoryImpl;
import me.mohammedriazkhan.repositories.employees.DoctorRepository;
import me.mohammedriazkhan.services.employees.DoctorService;

import java.util.Set;

@Service
public class DoctorServiceImpl implements DoctorService {

    private DoctorServiceImpl service = null;
    private DoctorRepository repository;

    public DoctorServiceImpl() {
        repository = DoctorRepositoryImpl.getDoctorRepository();
    }

    public DoctorServiceImpl getService(){

        if(service == null){
            return new DoctorServiceImpl();
        }
        return service;
    }

    @Override
    public Set<Doctor> getAll() {
        return repository.getAll();
    }

    @Override
    public Doctor create(Doctor doctor) {
        return repository.create(doctor);
    }

    @Override
    public Doctor read(Integer integer) {
        return repository.read(integer);
    }

    @Override
    public Doctor update(Doctor doctor) {
        return repository.update(doctor);
    }

    @Override
    public void delete(Integer integer) {

        repository.delete(integer);
    }


}
