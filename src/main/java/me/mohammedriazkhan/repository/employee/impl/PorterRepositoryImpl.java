package me.mohammedriazkhan.repository.employee.impl;

import me.mohammedriazkhan.domain.employee.Porter;
import me.mohammedriazkhan.repository.employee.PorterRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Repository("InMemory")
public class PorterRepositoryImpl implements PorterRepository {

    private static PorterRepositoryImpl repository = null;
    private Map<Integer, Porter> porters;

    public PorterRepositoryImpl(){
        porters = new HashMap<>();
    }


    public static PorterRepositoryImpl getRepository() {

        if(repository == null){
            return new PorterRepositoryImpl();
        }
        return repository;
    }

    /*public Porter find(int id) {
        return porters.stream().filter(porter -> porter.getEmployeeId() == id).findAny().orElse(null);
    }*/

    @Override
    public Porter create(Porter porter) {

        porters.put(porter.getEmployeeId(), porter);
        return porter;
    }

    @Override
    public Porter read(Integer id) {

        return porters.get(id);
    }

    @Override
    public Porter update(Porter porter) {

       porters.replace(porter.getEmployeeId(), porter);
       return porters.get(porter.getEmployeeId());
    }

    @Override
    public void delete(Integer id) {
       porters.remove(id);

    }

    @Override
    public Set<Porter> getAll() {
        return new HashSet<>(porters.values());
    }

}
