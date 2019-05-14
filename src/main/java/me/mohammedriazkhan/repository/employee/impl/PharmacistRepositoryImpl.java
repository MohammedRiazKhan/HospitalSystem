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
    private Map<Integer, Pharmacist> pharmacists;

    public PharmacistRepositoryImpl(){
        pharmacists = new HashMap<>();
    }

    public static PharmacistRepositoryImpl getRepository() {

        if(repository == null){
            return new PharmacistRepositoryImpl();
        }

        return repository;
    }

    /*public Pharmacist find(int id) {
        return pharmacists.stream().filter(pharmacist -> pharmacist.getEmployeeId() == id).findAny().orElse(null);
    }*/

    @Override
    public Pharmacist create(Pharmacist pharmacist) {

        pharmacists.put(pharmacist.getEmployeeId(), pharmacist);

        return pharmacist;
    }

    @Override
    public Pharmacist read(Integer id) {
       return pharmacists.get(id);
    }

    @Override
    public Pharmacist update(Pharmacist pharmacist) {

        pharmacists.replace(pharmacist.getEmployeeId(), pharmacist);
        return pharmacists.get(pharmacist.getEmployeeId());
    }

    @Override
    public void delete(Integer id) {

        pharmacists.remove(id);

    }

    @Override
    public Set<Pharmacist> getAll() {
        return new HashSet<>(pharmacists.values());
    }


}
