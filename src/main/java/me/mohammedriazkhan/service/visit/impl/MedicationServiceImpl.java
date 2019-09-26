package me.mohammedriazkhan.service.visit.impl;

import me.mohammedriazkhan.domain.visit.Medication;
import me.mohammedriazkhan.repository.visit.hibernate.MedicationRepositoryHibernate;
import me.mohammedriazkhan.repository.visit.impl.MedicationRepositoryImpl;
import me.mohammedriazkhan.repository.visit.MedicationRepository;
import me.mohammedriazkhan.service.visit.MedicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Service
public class MedicationServiceImpl implements MedicationService {

    private MedicationServiceImpl service = null;
    @Autowired
    private MedicationRepositoryHibernate repository;

    public MedicationServiceImpl() {

    }

    public MedicationServiceImpl getService(){

        if(service == null){
            return new MedicationServiceImpl();
        }
        return service;
    }

    @Override
    public Set<Medication> getAll() {
        List<Medication> list = (List<Medication>) repository.findAll();

        return new HashSet<>(list);
    }

    @Override
    public Medication create(Medication medication) {
        return repository.save(medication);
    }

    @Override
    public Medication read(String integer) {
        return repository.findById(integer).orElse(null);
    }

    @Override
    public Medication update(Medication medication) {
        return repository.save(medication);
    }

    @Override
    public void delete(String integer) {

        repository.deleteById(integer);
    }
}
