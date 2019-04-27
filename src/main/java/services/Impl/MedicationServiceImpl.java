package services.Impl;

import domain.visits.Medication;
import repositories.Impl.MedicationRepositoryImpl;
import repositories.visits.MedicationRepository;
import services.visits.MedicationService;

import java.util.Set;

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
