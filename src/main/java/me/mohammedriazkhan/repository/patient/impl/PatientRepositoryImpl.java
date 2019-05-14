package me.mohammedriazkhan.repository.patient.impl;

import me.mohammedriazkhan.domain.patient.Patient;
import me.mohammedriazkhan.repository.patient.PatientRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Repository("PatientInMemory")
public class PatientRepositoryImpl implements PatientRepository{

    private static PatientRepositoryImpl repository = null;
    private Map<Integer, Patient> patients;

    public PatientRepositoryImpl(){
        patients = new HashMap<>();
    }

    public static PatientRepositoryImpl getRepository(){
        if(repository == null){
            repository = new PatientRepositoryImpl();
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
