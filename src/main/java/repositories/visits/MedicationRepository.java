package repositories.visits;

import domain.visits.MedicalTool;
import domain.visits.Medication;
import domain.visits.Visit;
import repositories.Repository;

import java.util.HashSet;
import java.util.Set;

public class MedicationRepository implements Repository<Medication> {

    private static MedicationRepository repository = null;
    private Set<Medication> medication;

    public MedicationRepository(){
        medication = new HashSet<>();
    }

    public static MedicationRepository getRepository() {

        if(repository == null){
            return new MedicationRepository();
        }
        return repository;
    }

    @Override
    public Medication find(int id) {
        return medication.stream().filter(medication1 -> medication1.getMedicationId() == id).findAny().orElse(null);
    }

    @Override
    public void create(Medication medication1) {

        medication.add(medication1);

    }

    @Override
    public Medication read(int id) {
        return find(id);
    }

    @Override
    public void update(Medication medication1) {

        Medication medication2 = find(medication1.getMedicationId());
        if(medication.contains(medication2)){

            medication.remove(medication2);
            medication.add(medication1);

        }

    }

    @Override
    public void delete(Medication medication1) {

        medication.remove(medication1);
    }

    @Override
    public Set<Medication> getAll() {
        return medication;
    }


}
