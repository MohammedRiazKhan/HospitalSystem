package me.mohammedriazkhan.service.patient.impl;

import me.mohammedriazkhan.domain.patient.InPatient;
import me.mohammedriazkhan.repository.patient.hibernate.InPatientRepositoryHibernate;
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
    public Set<InPatient> getAll() {
        List<InPatient> list = (List<InPatient>) repository.findAll();

        return new HashSet<>(list);
    }

    @Override
    public InPatient create(InPatient patient) {
        return repository.save(patient);
    }

    @Override
    public InPatient read(String integer) {
        return repository.findById(integer).orElse(null);
    }

    @Override
    public InPatient update(InPatient patient) {
        return repository.save(patient);
    }

    @Override
    public void delete(String integer) {

        repository.deleteById(integer);
    }
}
