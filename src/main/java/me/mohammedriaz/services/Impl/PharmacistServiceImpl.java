package me.mohammedriaz.services.Impl;

import me.mohammedriaz.domain.employee.Pharmacist;
import me.mohammedriaz.repositories.Impl.PharmacistRepositoryImpl;
import me.mohammedriaz.repositories.employees.PharmacistRepository;
import me.mohammedriaz.services.employees.PharmicistService;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
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
