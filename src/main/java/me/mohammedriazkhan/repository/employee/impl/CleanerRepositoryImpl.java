package me.mohammedriazkhan.repository.employee.impl;

import me.mohammedriazkhan.domain.employee.Cleaner;
import me.mohammedriazkhan.repository.employee.CleanerRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Repository
public class CleanerRepositoryImpl implements CleanerRepository{

    private static CleanerRepositoryImpl cleanerRepository = null;
    private Set<Cleaner> cleaners;

    public CleanerRepositoryImpl(){
        cleaners = new HashSet<>();
    }

    public static CleanerRepositoryImpl getCleanerRepository() {

        if(cleanerRepository == null){
            return new CleanerRepositoryImpl();
        }
        return cleanerRepository;
    }


    @Override
    public Cleaner create(Cleaner cleaner) {

        cleaners.add(cleaner);

        return cleaner;
    }

    @Override
    public Cleaner read(String id) {

       return cleaners.stream().filter(cleaner -> cleaner.getEmployeeId().equals(id)).findAny().orElse(null);
    }

    @Override
    public Cleaner update(Cleaner cleaner) {
        Cleaner inDB = read(cleaner.getEmployeeId());
        if(inDB != null){
            cleaners.remove(inDB);
            cleaners.add(cleaner);
            return cleaner;
        }

        return null;

    }

    @Override
    public void delete(String id) {

        Cleaner inDB = read(id);
        cleaners.remove(inDB);

    }

    @Override
    public Set<Cleaner> getAll() {
        return cleaners;
    }
}
