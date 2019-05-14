package me.mohammedriazkhan.repository.patient.impl;

import me.mohammedriazkhan.domain.patient.Patient;
import me.mohammedriazkhan.repository.patient.OutPatientRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Repository("InMemory")
public class OutPatientRepositoryImpl implements OutPatientRepository {

    private static OutPatientRepositoryImpl repository = null;
    private Map<Integer, Patient> patients;

    private OutPatientRepositoryImpl(){
        patients = new HashMap<>();
    }

    public static OutPatientRepositoryImpl getRepository(){
        if(repository == null){
            repository = new OutPatientRepositoryImpl();
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

    /*public Patient find(int id) {
        return patients.stream().filter(patient -> patient.getPatientId() == id).findAny().orElse(null);
    }*/

}
