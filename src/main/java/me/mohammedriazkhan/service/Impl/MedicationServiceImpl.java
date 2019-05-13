package me.mohammedriazkhan.service.Impl;

import me.mohammedriazkhan.domain.visit.Medication;
import me.mohammedriazkhan.repository.Impl.MedicationRepositoryImpl;
import me.mohammedriazkhan.repository.visit.MedicationRepository;
import me.mohammedriazkhan.service.visit.MedicationService;
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
