package services.Impl;

import domain.visits.Visit;
import repositories.Impl.VisitRepositoryImpl;
import repositories.visits.VisitRepository;
import services.visits.VisitService;

import java.util.Set;

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
