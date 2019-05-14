package me.mohammedriazkhan.repository.employee.impl;

import me.mohammedriazkhan.domain.employee.Cleaner;
import me.mohammedriazkhan.repository.employee.CleanerRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Repository("CleanerInMemory")
public class CleanerRepositoryImpl implements CleanerRepository{

    private static CleanerRepositoryImpl cleanerRepository = null;
    private Map<Integer, Cleaner> cleaners;

    private CleanerRepositoryImpl(){
        cleaners = new HashMap<>();
    }

    public static CleanerRepositoryImpl getCleanerRepository() {

        if(cleanerRepository == null){
            return new CleanerRepositoryImpl();
        }
        return cleanerRepository;
    }


    /*public Cleaner find(int id) {
        return cleaners.stream().filter(cleaner -> cleaner.getEmployeeId() == id).findAny().orElse(null);
    }*/

    @Override
    public Cleaner create(Cleaner cleaner) {

        cleaners.put(cleaner.getEmployeeId(), cleaner);

        return cleaner;
    }

    @Override
    public Cleaner read(Integer id) {

       return cleaners.get(id);
    }

    @Override
    public Cleaner update(Cleaner cleaner) {

        cleaners.replace(cleaner.getEmployeeId(), cleaner);
        return cleaners.get(cleaner.getEmployeeId());
    }

    @Override
    public void delete(Integer id) {

        cleaners.remove(id);

    }

    @Override
    public Set<Cleaner> getAll() {
        return new HashSet<>(cleaners.values());
    }
}
