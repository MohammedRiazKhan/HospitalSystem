package me.mohammedriazkhan.repository.Impl;

import me.mohammedriazkhan.domain.employee.Cleaner;
import me.mohammedriazkhan.repository.employees.CleanerRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository
public class CleanerRepositoryImpl implements CleanerRepository{

    private static CleanerRepositoryImpl cleanerRepository = null;
    private Set<Cleaner> cleaners;

    private CleanerRepositoryImpl(){
        cleaners = new HashSet<>();
    }

    public static CleanerRepositoryImpl getCleanerRepository() {

        if(cleanerRepository == null){
            return new CleanerRepositoryImpl();
        }
        return cleanerRepository;
    }


    public Cleaner find(int id) {
        return cleaners.stream().filter(cleaner -> cleaner.getEmployeeId() == id).findAny().orElse(null);
    }

    @Override
    public Cleaner create(Cleaner cleaner) {

        cleaners.add(cleaner);

        return cleaner;
    }

    @Override
    public Cleaner read(Integer id) {

        Cleaner cleaner = find(id);

        if(cleaner == null){
            return null;
        }
        else{
            return cleaner;
        }
    }

    @Override
    public Cleaner update(Cleaner cleaner) {

        Cleaner cleaner1 = find(cleaner.getEmployeeId());

        if(cleaners.contains(cleaner1)){

            cleaners.remove(cleaner1);
            cleaners.add(cleaner);

        }

        return cleaner1;
    }

    @Override
    public void delete(Integer id) {

        Cleaner cleaner = find(id);
        cleaners.remove(cleaner);

    }

    @Override
    public Set<Cleaner> getAll() {
        return cleaners;
    }
}
