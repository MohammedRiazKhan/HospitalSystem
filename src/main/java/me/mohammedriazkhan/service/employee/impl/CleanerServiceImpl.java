package me.mohammedriazkhan.service.employee.impl;

import me.mohammedriazkhan.domain.employee.Cleaner;
import me.mohammedriazkhan.repository.employee.impl.CleanerRepositoryImpl;
import me.mohammedriazkhan.repository.employee.CleanerRepository;
import me.mohammedriazkhan.service.employee.CleanerService;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service("CleanerServiceImpl")
public class CleanerServiceImpl implements CleanerService {

    private CleanerServiceImpl service = null;
    private CleanerRepository repository;

    public CleanerServiceImpl(){
        this.repository = CleanerRepositoryImpl.getCleanerRepository();
    }

    public CleanerServiceImpl getService(){
        if (service == null){
            service = new CleanerServiceImpl();
        }
        return service;
    }

    @Override
    public Set<Cleaner> getAll() {
        return repository.getAll();
    }

    @Override
    public Cleaner create(Cleaner cleaner) {
        return repository.create(cleaner);
    }

    @Override
    public Cleaner read(String integer) {
        return repository.read(integer);
    }

    @Override
    public Cleaner update(Cleaner cleaner) {
        return repository.update(cleaner);
    }

    @Override
    public void delete(String integer) {
        repository.delete(integer);
    }



}
