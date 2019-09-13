package me.mohammedriazkhan.repository.employee.impl;

import me.mohammedriazkhan.domain.employee.Pharmacist;
import me.mohammedriazkhan.repository.employee.PharmacistRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Repository("PharmacistInMemory")
public class PharmacistRepositoryImpl implements PharmacistRepository {


    private static PharmacistRepositoryImpl repository = null;
    private HashSet<Pharmacist> pharmacists;

    public PharmacistRepositoryImpl(){
        pharmacists = new HashSet<>();
    }

    public static PharmacistRepositoryImpl getRepository() {

        if(repository == null){
            return new PharmacistRepositoryImpl();
        }

        return repository;
    }

    @Override
    public Pharmacist create(Pharmacist pharmacist) {

        pharmacists.add(pharmacist);

        return pharmacist;
    }

    @Override
    public Pharmacist read(String id) {
       return pharmacists.stream().filter(pharmacist -> pharmacist.getEmployeeId().equals(id)).findAny().orElse(null);
    }

    @Override
    public Pharmacist update(Pharmacist pharmacist) {

        Pharmacist inDB = read(pharmacist.getEmployeeId());
        if(inDB != null){
            pharmacists.remove(inDB);
            pharmacists.add(pharmacist);
            return pharmacist;
        }

        return null;
    }

    @Override
    public void delete(String id) {

        Pharmacist inDB = read(id);
        pharmacists.remove(inDB);

    }

    @Override
    public Set<Pharmacist> getAll() {
        return pharmacists;
    }


}
