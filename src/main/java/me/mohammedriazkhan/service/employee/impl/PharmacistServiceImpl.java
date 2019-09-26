package me.mohammedriazkhan.service.employee.impl;

import me.mohammedriazkhan.domain.employee.Pharmacist;
import me.mohammedriazkhan.repository.employee.hibernate.PharmacistRepositoryHibernate;
import me.mohammedriazkhan.repository.employee.impl.PharmacistRepositoryImpl;
import me.mohammedriazkhan.repository.employee.PharmacistRepository;
import me.mohammedriazkhan.service.employee.PharmicistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Service
public class PharmacistServiceImpl implements PharmicistService {

    private PharmacistServiceImpl service = null;
    @Autowired
    private PharmacistRepositoryHibernate repository;

    public PharmacistServiceImpl() {
    }

    public PharmacistServiceImpl getService(){

        if(service == null){
            return new PharmacistServiceImpl();
        }
        return service;
    }

    @Override
    public Set<Pharmacist> getAll() {
        List<Pharmacist> list = (List<Pharmacist>) repository.findAll();

        return new HashSet<>(list);
    }

    @Override
    public Pharmacist create(Pharmacist pharmacist) {
        return repository.save(pharmacist);
    }

    @Override
    public Pharmacist read(String integer) {
        return repository.findById(integer).orElse(null);
    }

    @Override
    public Pharmacist update(Pharmacist pharmacist) {
        return repository.save(pharmacist);
    }

    @Override
    public void delete(String integer) {

        repository.deleteById(integer);

    }
}
