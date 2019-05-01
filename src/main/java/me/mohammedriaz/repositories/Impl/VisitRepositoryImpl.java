package me.mohammedriaz.repositories.Impl;

import me.mohammedriaz.domain.visits.Visit;
import me.mohammedriaz.repositories.visits.VisitRepository;

import java.util.HashSet;
import java.util.Set;

public class VisitRepositoryImpl implements VisitRepository {

    private static VisitRepositoryImpl repository = null;
    private Set<Visit> visits;

    public VisitRepositoryImpl(){
        visits = new HashSet<>();
    }

    public static VisitRepositoryImpl getRepository() {

        if(repository == null){
            return new VisitRepositoryImpl();
        }
        return repository;
    }
    public Visit find(int id) {
        return visits.stream().filter(visit -> visit.getVisitId() == id).findAny().orElse(null);
    }

    @Override
    public Visit create(Visit visit) {

        visits.add(visit);

        return visit;
    }

    @Override
    public Visit read(Integer id) {

        Visit visit = find(id);

        if(visit == null){
            return null;
        }
        else {
            return visit;
        }
    }

    @Override
    public Visit update(Visit visit) {

        Visit visit1 = find(visit.getVisitId());
        if(visits.contains(visit1)){
            visits.remove(visit1);
            visits.add(visit);
        }

        return visit1;
    }

    @Override
    public void delete(Integer id) {

        Visit visit = find(id);
        visits.remove(visit);
    }

    @Override
    public Set<Visit> getAll() {
        return visits;
    }

}
