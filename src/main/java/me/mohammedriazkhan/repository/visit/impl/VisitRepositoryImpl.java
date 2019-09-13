package me.mohammedriazkhan.repository.visit.impl;

import me.mohammedriazkhan.domain.visit.Visit;
import me.mohammedriazkhan.repository.visit.VisitRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Repository("VisitInMemory")
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

    @Override
    public Visit create(Visit visit) {

        visits.add(visit);

        return visit;
    }

    @Override
    public Visit read(String id) {

       return visits.stream().filter(visit -> visit.getVisitId().equals(id)).findAny().orElse(null);
    }

    @Override
    public Visit update(Visit visit) {

        Visit inDB = read(visit.getVisitId());
        if(inDB != null){

            visits.remove(inDB);
            visits.add(visit);
            return visit;

        }
        return null;
    }

    @Override
    public void delete(String id) {

        Visit inDB = read(id);
        visits.remove(inDB);

    }

    @Override
    public Set<Visit> getAll() {
        return visits;
    }

}
