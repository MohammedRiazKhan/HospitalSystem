package me.mohammedriaz.services.Impl;

import me.mohammedriaz.domain.patients.Patient;
import me.mohammedriaz.repositories.Impl.PatientRepositoryImpl;
import me.mohammedriaz.repositories.patients.PatientRepository;
import me.mohammedriaz.services.patients.PatientService;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class PatientServiceImpl implements PatientService {

    private PatientServiceImpl service = null;
    private PatientRepository repository;

    public PatientServiceImpl() {
        repository = PatientRepositoryImpl.getRepository();
    }

    public PatientServiceImpl getService(){

        if(service == null){
            return new PatientServiceImpl();
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
