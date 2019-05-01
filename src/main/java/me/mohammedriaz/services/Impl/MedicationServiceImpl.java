package me.mohammedriaz.services.Impl;

import me.mohammedriaz.domain.visits.Medication;
import me.mohammedriaz.repositories.Impl.MedicationRepositoryImpl;
import me.mohammedriaz.repositories.visits.MedicationRepository;
import me.mohammedriaz.services.visits.MedicationService;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class MedicationServiceImpl implements MedicationService {

    private MedicationServiceImpl service = null;
    private MedicationRepository repository;

    public MedicationServiceImpl() {
        repository = MedicationRepositoryImpl.getRepository();
    }

    public MedicationServiceImpl getService(){

        if(service == null){
            return new MedicationServiceImpl();
        }
        return service;
    }

    @Override
    public Set<Medication> getAll() {
        return repository.getAll();
    }

    @Override
    public Medication create(Medication medication) {
        return repository.create(medication);
    }

    @Override
    public Medication read(Integer integer) {
        return repository.read(integer);
    }

    @Override
    public Medication update(Medication medication) {
        return repository.update(medication);
    }

    @Override
    public void delete(Integer integer) {

        repository.delete(integer);
    }
}
