package me.mohammedriazkhan.service.patient.impl;

import me.mohammedriazkhan.domain.patient.Patient;
import me.mohammedriazkhan.repository.patient.InPatientRepository;
import me.mohammedriazkhan.repository.patient.hibernate.InPatientRepositoryHibernate;
import me.mohammedriazkhan.repository.patient.impl.InPatientRepositoryImpl;
import me.mohammedriazkhan.service.patient.InPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Service
public class InPatientServiceImpl implements InPatientService {

    private static InPatientServiceImpl service = null;
    @Autowired
    private InPatientRepositoryHibernate repository;

    public InPatientServiceImpl() {

    }

    public static InPatientServiceImpl getService(){

        if(service == null){
            return new InPatientServiceImpl();
        }
        return service;
    }

    @Override
    public Set<Patient> getAll() {
        List<Patient> list = (List<Patient>) repository.findAll();

        return new HashSet<>(list);
    }

    @Override
    public Patient create(Patient patient) {
        return repository.save(patient);
    }

    @Override
    public Patient read(String integer) {
        return repository.findById(integer).orElse(null);
    }

    @Override
    public Patient update(Patient patient) {
        return repository.save(patient);
    }

    @Override
    public void delete(String integer) {

        repository.deleteById(integer);
    }
}
