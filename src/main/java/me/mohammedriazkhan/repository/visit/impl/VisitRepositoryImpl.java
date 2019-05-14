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
    private Map<Integer, Visit> visits;

    public VisitRepositoryImpl(){
        visits = new HashMap<>();
    }

    public static VisitRepositoryImpl getRepository() {

        if(repository == null){
            return new VisitRepositoryImpl();
        }
        return repository;
    }

    @Override
    public Visit create(Visit visit) {

        visits.put(visit.getVisitId(), visit);

        return visit;
    }

    @Override
    public Visit read(Integer id) {

       return visits.get(id);
    }

    @Override
    public Visit update(Visit visit) {

      visits.replace(visit.getVisitId(), visit);
      return visits.get(visit.getVisitId());
    }

    @Override
    public void delete(Integer id) {

        visits.remove(id);

    }

    @Override
    public Set<Visit> getAll() {
        return new HashSet<>(visits.values());
    }

}
