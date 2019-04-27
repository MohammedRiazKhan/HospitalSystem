package services.Impl;

import domain.employee.Pharmacist;
import repositories.Impl.PharmacistRepositoryImpl;
import repositories.employees.PharmacistRepository;
import services.employees.PharmicistService;

import java.util.Set;

public class PharmacistServiceImpl implements PharmicistService {

    private PharmacistServiceImpl service = null;
    private PharmacistRepository repository;

    public PharmacistServiceImpl() {
        repository = PharmacistRepositoryImpl.getRepository();
    }

    public PharmacistServiceImpl getService(){

        if(service == null){
            return new PharmacistServiceImpl();
        }
        return service;
    }

    @Override
    public Set<Pharmacist> getAll() {
        return repository.getAll();
    }

    @Override
    public Pharmacist create(Pharmacist pharmacist) {
        return repository.create(pharmacist);
    }

    @Override
    public Pharmacist read(Integer integer) {
        return repository.read(integer);
    }

    @Override
    public Pharmacist update(Pharmacist pharmacist) {
        return repository.update(pharmacist);
    }

    @Override
    public void delete(Integer integer) {

        repository.delete(integer);

    }
}
