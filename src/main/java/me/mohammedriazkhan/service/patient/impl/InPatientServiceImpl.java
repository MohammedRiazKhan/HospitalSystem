package me.mohammedriazkhan.service.patient.impl;

import me.mohammedriazkhan.domain.patient.Patient;
import me.mohammedriazkhan.repository.patient.InPatientRepository;
import me.mohammedriazkhan.repository.patient.impl.InPatientRepositoryImpl;
import me.mohammedriazkhan.service.patient.InPatientService;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class InPatientServiceImpl implements InPatientService {

    private InPatientServiceImpl service = null;
    private InPatientRepository repository;

    public InPatientServiceImpl() {
        repository = InPatientRepositoryImpl.getRepository();
    }

    public InPatientServiceImpl getService(){

        if(service == null){
            return new InPatientServiceImpl();
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
    public Patient read(String integer) {
        return repository.read(integer);
    }

    @Override
    public Patient update(Patient patient) {
        return repository.update(patient);
    }

    @Override
    public void delete(String integer) {

        repository.delete(integer);
    }
}
