package me.mohammedriaz.repositories.Impl;

import me.mohammedriaz.domain.employee.Porter;
import me.mohammedriaz.repositories.employees.PorterRepository;

import java.util.HashSet;
import java.util.Set;

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

    public Porter find(int id) {
        return porters.stream().filter(porter -> porter.getEmployeeId() == id).findAny().orElse(null);
    }

    @Override
    public Porter create(Porter porter) {

        porters.add(porter);

        return porter;
    }

    @Override
    public Porter read(Integer id) {

        Porter porter = find(id);

        if(porter == null){
            return null;
        }
        else {
            return porter;
        }
    }

    @Override
    public Porter update(Porter porter) {

        Porter porter1 = find(porter.getEmployeeId());

        if(porters.contains(porter1)){
            porters.remove(porter1);
            porters.add(porter);
        }

        return porter1;
    }

    @Override
    public void delete(Integer id) {
        Porter porter = find(id);
        porters.remove(porter);

    }

    @Override
    public Set<Porter> getAll() {
        return porters;
    }

}
