package repositories.Impl;

import domain.employee.Pharmacist;
import repositories.employees.PharmacistRepository;

import java.util.HashSet;
import java.util.Set;

public class PharmacistRepositoryImpl implements PharmacistRepository {


    private static PharmacistRepositoryImpl repository = null;
    private Set<Pharmacist> pharmacists;

    public PharmacistRepositoryImpl(){
        pharmacists = new HashSet<>();
    }

    public static PharmacistRepositoryImpl getRepository() {

        if(repository == null){
            return new PharmacistRepositoryImpl();
        }

        return repository;
    }

    public Pharmacist find(int id) {
        return pharmacists.stream().filter(pharmacist -> pharmacist.getEmployeeId() == id).findAny().orElse(null);
    }

    @Override
    public Pharmacist create(Pharmacist pharmacist) {

        pharmacists.add(pharmacist);

        return pharmacist;
    }

    @Override
    public Pharmacist read(Integer id) {
        Pharmacist pharmacist = find(id);

        if(pharmacist == null){
            return null;
        }
        else {
            return pharmacist;
        }
    }

    @Override
    public Pharmacist update(Pharmacist pharmacist) {

        Pharmacist pharmacist1 = find(pharmacist.getEmployeeId());

        if(pharmacists.contains(pharmacist1)){
            pharmacists.remove(pharmacist1);
            pharmacists.add(pharmacist);
        }

        return pharmacist1;
    }

    @Override
    public void delete(Integer id) {

        Pharmacist pharmacist = find(id);

        pharmacists.remove(pharmacist);

    }

    @Override
    public Set<Pharmacist> getAll() {
        return pharmacists;
    }


}
