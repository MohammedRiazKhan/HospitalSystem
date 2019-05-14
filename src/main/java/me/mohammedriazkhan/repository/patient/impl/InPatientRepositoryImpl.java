package me.mohammedriazkhan.repository.patient.impl;

import me.mohammedriazkhan.domain.patient.Patient;
import me.mohammedriazkhan.repository.patient.InPatientRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Repository("InPatientInMemory")
public class InPatientRepositoryImpl implements InPatientRepository {

    private static InPatientRepositoryImpl repository = null;
    private Map<Integer, Patient> patients;

    private InPatientRepositoryImpl(){
        patients = new HashMap<>();
    }

    public static InPatientRepositoryImpl getRepository(){
        if(repository == null){
            repository = new InPatientRepositoryImpl();
        }

        return repository;
    }

    @Override
    public Patient create(Patient patient) {
        patients.put(patient.getPatientId(), patient);
        return patient;
    }

    @Override
    public Patient update(Patient patient) {

        patients.replace(patient.getPatientId(), patient);
        return patients.get(patient.getPatientId());
    }

    @Override
    public void delete(Integer id) {

        patients.remove(id);
    }

    @Override
    public Patient read(Integer id) {

        return patients.get(id);

    }

    @Override
    public Set<Patient> getAll() {
        return new HashSet<>(patients.values());
    }


}
