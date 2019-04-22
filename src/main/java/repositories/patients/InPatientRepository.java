package repositories.patients;

import domain.patients.Patient;
import repositories.Repository;

import java.util.HashSet;
import java.util.Set;

public class InPatientRepository implements Repository<Patient> {

    private static PatientRepository repository = null;
    private Set<Patient> patients;

    private InPatientRepository(){
        patients = new HashSet<>();
    }

    public static PatientRepository getRepository(){
        if(repository == null){
            repository = new PatientRepository();
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
    public void delete(Patient patient) {

        patients.remove(patient);
    }

    @Override
    public Patient read(final int id) {
        return find(id);
    }

    @Override
    public Set<Patient> getAll() {
        return patients;
    }

    @Override
    public Patient find(int id) {
        return patients.stream().filter(patient -> patient.getPatientId() == id).findAny().orElse(null);
    }


}
