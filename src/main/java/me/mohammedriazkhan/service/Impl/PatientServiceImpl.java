package me.mohammedriazkhan.service.Impl;

import me.mohammedriazkhan.domain.patient.Patient;
import me.mohammedriazkhan.repository.Impl.PatientRepositoryImpl;
import me.mohammedriazkhan.repository.patient.PatientRepository;
import me.mohammedriazkhan.service.patient.PatientService;
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
