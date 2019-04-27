package repositories.Impl;

import domain.patients.Patient;
import repositories.patients.OutPatientRepository;
import repositories.patients.PatientRepository;

import java.util.HashSet;
import java.util.Set;

public class OutPatientRepositoryImpl implements OutPatientRepository {

    private static OutPatientRepositoryImpl repository = null;
    private Set<Patient> patients;

    private OutPatientRepositoryImpl(){
        patients = new HashSet<>();
    }

    public static OutPatientRepositoryImpl getRepository(){
        if(repository == null){
            repository = new OutPatientRepositoryImpl();
        }

        return repository;
    }



    @Override
    public void create(Patient patient) {
        patients.add(patient);
    }

    @Override
    public void update(Patient patient) {

        Patient patientFound = find(patient.getPatientId());

        if(patients.contains(patientFound)){
            patients.remove(patientFound);
            patients.add(patient);
        }

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
