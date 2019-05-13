package me.mohammedriazkhan.repository.Impl;

import me.mohammedriazkhan.domain.patient.Patient;
import me.mohammedriazkhan.repository.patient.PatientRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository
public class PatientRepositoryImpl implements PatientRepository{

    private static PatientRepositoryImpl repository = null;
    private Set<Patient> patients;

    public PatientRepositoryImpl(){
        patients = new HashSet<>();
    }

    public static PatientRepositoryImpl getRepository(){
        if(repository == null){
            repository = new PatientRepositoryImpl();
        }

        return repository;
    }


    @Override
    public Patient create(Patient patient) {
        patients.add(patient);
        return patient;
    }

    @Override
    public Patient update(Patient patient) {

        Patient patientFound = find(patient.getPatientId());

        if(patients.contains(patientFound)){
            patients.remove(patientFound);
            patients.add(patient);
        }

        return patientFound;
    }

    @Override
    public void delete(Integer id) {

        Patient patient = find(id);
        patients.remove(patient);
    }

    @Override
    public Patient read(Integer id) {

        Patient patient = find(id);
        if(patient == null){
            return null;
        }
        else{
            return patient;
        }

    }

    @Override
    public Set<Patient> getAll() {
        return patients;
    }

    public Patient find(int id) {
        return patients.stream().filter(patient -> patient.getPatientId() == id).findAny().orElse(null);
    }

}
