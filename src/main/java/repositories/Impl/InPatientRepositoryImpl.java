package repositories.Impl;

import domain.patients.Patient;
import repositories.patients.InPatientRepository;
import repositories.patients.PatientRepository;

import java.util.HashSet;
import java.util.Set;

public class InPatientRepositoryImpl implements InPatientRepository {

    private static InPatientRepositoryImpl repository = null;
    private Set<Patient> patients;

    private InPatientRepositoryImpl(){
        patients = new HashSet<>();
    }

    public static InPatientRepositoryImpl getRepository(){
        if(repository == null){
            repository = new InPatientRepositoryImpl();
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
