package me.mohammedriaz.services.Impl;

import me.mohammedriaz.domain.visits.Visit;
import me.mohammedriaz.repositories.Impl.VisitRepositoryImpl;
import me.mohammedriaz.repositories.visits.VisitRepository;
import me.mohammedriaz.services.visits.VisitService;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class VisitServiceImpl implements VisitService {

    private VisitServiceImpl service = null;
    private VisitRepository repository;

    public VisitServiceImpl() {
        repository = VisitRepositoryImpl.getRepository();
    }

    public VisitServiceImpl getService(){

        if(service == null){
            return new VisitServiceImpl();
        }
        return service;
    }

    @Override
    public Set<Visit> getAll() {
        return repository.getAll();
    }

    @Override
    public Visit create(Visit visit) {
        return repository.create(visit);
    }

    @Override
    public Visit read(Integer integer) {
        return repository.read(integer);
    }

    @Override
    public Visit update(Visit visit) {
        return repository.update(visit);
    }

    @Override
    public void delete(Integer integer) {

        repository.delete(integer);
    }
}
