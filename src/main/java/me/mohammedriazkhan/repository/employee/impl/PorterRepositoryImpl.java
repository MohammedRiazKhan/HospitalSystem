package me.mohammedriazkhan.repository.employee.impl;

import me.mohammedriazkhan.domain.employee.Porter;
import me.mohammedriazkhan.repository.employee.PorterRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Repository("PorterInMemory")
public class PorterRepositoryImpl implements PorterRepository {

    private static PorterRepositoryImpl repository = null;
    private Set<Porter> porters;

    public PorterRepositoryImpl(){
        porters = new HashSet<>();
    }


    public static PorterRepositoryImpl getRepository() {

        if(repository == null){
            return new PorterRepositoryImpl();
        }
        return repository;
    }

    @Override
    public Porter create(Porter porter) {

        porters.add(porter);
        return porter;
    }

    @Override
    public Porter read(String id) {

        return porters.stream().filter(porter -> porter.getEmployeeId().equals(id)).findAny().orElse(null);
    }

    @Override
    public Porter update(Porter porter) {

        Porter inDB = read(porter.getEmployeeId());

        if(inDB != null){
            porters.remove(inDB);
            porters.add(porter);
            return porter;
        }

        return null;
    }

    @Override
    public void delete(String id) {

        Porter inDB = read(id);
       porters.remove(inDB);

    }

    @Override
    public Set<Porter> getAll() {
        return porters;
    }

}
