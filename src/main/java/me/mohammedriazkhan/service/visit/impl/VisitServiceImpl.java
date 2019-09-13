package me.mohammedriazkhan.service.visit.impl;

import me.mohammedriazkhan.domain.visit.Visit;
import me.mohammedriazkhan.repository.visit.impl.VisitRepositoryImpl;
import me.mohammedriazkhan.repository.visit.VisitRepository;
import me.mohammedriazkhan.service.visit.VisitService;
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
    public Visit read(String integer) {
        return repository.read(integer);
    }

    @Override
    public Visit update(Visit visit) {
        return repository.update(visit);
    }

    @Override
    public void delete(String integer) {

        repository.delete(integer);
    }
}
