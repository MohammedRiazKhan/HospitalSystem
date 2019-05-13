package me.mohammedriazkhan.service.Impl;

import me.mohammedriazkhan.domain.patients.Patient;
import me.mohammedriazkhan.repository.Impl.OutPatientRepositoryImpl;
import me.mohammedriazkhan.repository.patients.OutPatientRepository;
import me.mohammedriazkhan.service.patients.OutPatientService;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class OutPatientServiceImpl implements OutPatientService {

    private OutPatientServiceImpl service = null;
    private OutPatientRepository repository;

    public OutPatientServiceImpl() {
        repository = OutPatientRepositoryImpl.getRepository();
    }

    public OutPatientServiceImpl getService(){

        if(service == null){
            return new OutPatientServiceImpl();
        }
        return service;
    }

    @Override
    public Set<Patient> getAll() {
        return repository.getAll();
    }

    @Override
    public Patient create(Patient patient) {
        return repository.create(patient);
    }

    @Override
    public Patient read(Integer integer) {
        return repository.read(integer);
    }

    @Override
    public Patient update(Patient patient) {
        return repository.update(patient);
    }

    @Override
    public void delete(Integer integer) {

        repository.delete(integer);
    }
}
