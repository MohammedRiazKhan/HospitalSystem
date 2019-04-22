package repositories.employees;

import domain.employee.Pharmacist;
import repositories.Repository;

import java.util.HashSet;
import java.util.Set;

public class PharmacistRepository implements Repository<Pharmacist> {

    private static PharmacistRepository repository = null;
    private Set<Pharmacist> pharmacists;

    public PharmacistRepository(){
        pharmacists = new HashSet<>();
    }

    public static PharmacistRepository getRepository() {

        if(repository == null){
            return new PharmacistRepository();
        }

        return repository;
    }

    @Override
    public Pharmacist find(int id) {
        return pharmacists.stream().filter(pharmacist -> pharmacist.getEmployeeId() == id).findAny().orElse(null);
    }

    @Override
    public void create(Pharmacist pharmacist) {

        pharmacists.add(pharmacist);

    }

    @Override
    public Pharmacist read(int id) {
        return find(id);
    }

    @Override
    public void update(Pharmacist pharmacist) {

        Pharmacist pharmacist1 = find(pharmacist.getEmployeeId());

        if(pharmacists.contains(pharmacist1)){
            pharmacists.remove(pharmacist1);
            pharmacists.add(pharmacist);
        }

    }

    @Override
    public void delete(Pharmacist pharmacist) {

        pharmacists.remove(pharmacist);

    }

    @Override
    public Set<Pharmacist> getAll() {
        return pharmacists;
    }


}
