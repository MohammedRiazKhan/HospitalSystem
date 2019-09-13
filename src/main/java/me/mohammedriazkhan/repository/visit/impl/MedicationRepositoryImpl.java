package me.mohammedriazkhan.repository.visit.impl;

import me.mohammedriazkhan.domain.visit.Medication;
import me.mohammedriazkhan.repository.visit.MedicationRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Repository("MedicationInMemory")
public class MedicationRepositoryImpl implements MedicationRepository {

    private static MedicationRepositoryImpl repository = null;
    private Set<Medication> medication;

    public MedicationRepositoryImpl() {
        medication = new HashSet<>();
    }

    public static MedicationRepositoryImpl getRepository() {

        if (repository == null) {
            return new MedicationRepositoryImpl();
        }
        return repository;
    }


    @Override
    public Medication create(Medication medication1) {

        medication.add(medication1);

        return medication1;
    }

    @Override
    public Medication read(String id) {

       return medication.stream().filter(medication1 -> medication1.getMedicationId().equals(id)).findAny().orElse(null);

    }

    @Override
    public Medication update(Medication medication1) {

       Medication inDB = read(medication1.getMedicationId());
       if(inDB != null){
           medication.remove(inDB);
           medication.add(medication1);
           return medication1;
       }

       return medication1;
    }

    @Override
    public void delete(String id) {

        Medication inDB = read(id);

        medication.remove(inDB);
    }

    @Override
    public Set<Medication> getAll() {
        return medication;
    }


}
