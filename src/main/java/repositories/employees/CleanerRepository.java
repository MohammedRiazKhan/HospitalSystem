package repositories.employees;

import domain.employee.Cleaner;
import repositories.Repository;

import java.util.HashSet;
import java.util.Set;

public class CleanerRepository implements Repository<Cleaner> {

    private static CleanerRepository cleanerRepository = null;
    private Set<Cleaner> cleaners;

    private CleanerRepository(){
        cleaners = new HashSet<>();
    }

    public static CleanerRepository getCleanerRepository() {

        if(cleanerRepository == null){
            return new CleanerRepository();
        }
        return cleanerRepository;
    }


    @Override
    public Cleaner find(int id) {
        return cleaners.stream().filter(cleaner -> cleaner.getEmployeeId() == id).findAny().orElse(null);
    }

    @Override
    public void create(Cleaner cleaner) {

        cleaners.add(cleaner);

    }

    @Override
    public Cleaner read(final int id) {
        return find(id);
    }

    @Override
    public void update(Cleaner cleaner) {

        Cleaner cleaner1 = find(cleaner.getEmployeeId());

        if(cleaners.contains(cleaner1)){

            cleaners.remove(cleaner1);
            cleaners.add(cleaner);

        }

    }

    @Override
    public void delete(Cleaner cleaner) {

        cleaners.remove(cleaner);

    }

    @Override
    public Set<Cleaner> getAll() {
        return cleaners;
    }


}
