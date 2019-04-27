package repositories.Impl;

import domain.visits.Medication;
import repositories.visits.MedicationRepository;

import java.util.HashSet;
import java.util.Set;

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

    public Medication find(int id) {
        return medication.stream().filter(medication1 -> medication1.getMedicationId() == id).findAny().orElse(null);
    }

    @Override
    public Medication create(Medication medication1) {

        medication.add(medication1);

        return medication1;
    }

    @Override
    public Medication read(Integer id) {

        Medication medication = find(id);
        if (medication == null){
            return null;
        }
        else {
            return medication;
        }

    }

    @Override
    public Medication update(Medication medication1) {

        Medication medication2 = find(medication1.getMedicationId());
        if (medication.contains(medication2)) {

            medication.remove(medication2);
            medication.add(medication1);

        }

        return medication2;
    }



    @Override
    public void delete(Integer id) {
        Medication medications = find(id);
        medication.remove(medications);
    }

    @Override
    public Set<Medication> getAll() {
        return medication;
    }


}
