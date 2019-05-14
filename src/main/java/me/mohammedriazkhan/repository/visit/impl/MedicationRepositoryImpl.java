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
    private Map<Integer, Medication> medication;

    public MedicationRepositoryImpl() {
        medication = new HashMap<>();
    }

    public static MedicationRepositoryImpl getRepository() {

        if (repository == null) {
            return new MedicationRepositoryImpl();
        }
        return repository;
    }


    @Override
    public Medication create(Medication medication1) {

       medication.put(medication1.getMedicationId(), medication1);

        return medication1;
    }

    @Override
    public Medication read(Integer id) {

       return medication.get(id);

    }

    @Override
    public Medication update(Medication medication1) {


        medication.replace(medication1.getMedicationId(), medication1);
        return medication.get(medication1.getMedicationId());
    }



    @Override
    public void delete(Integer id) {

        medication.remove(id);
    }

    @Override
    public Set<Medication> getAll() {
        return new HashSet<>(medication.values());
    }


}
