package services.Impl;

import domain.employee.Cleaner;
import repositories.Impl.CleanerRepositoryImpl;
import repositories.employees.CleanerRepository;
import services.employees.CleanerService;

import java.util.Set;

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
    public Cleaner read(Integer integer) {
        return repository.read(integer);
    }

    @Override
    public Cleaner update(Cleaner cleaner) {
        return repository.update(cleaner);
    }

    @Override
    public void delete(Integer integer) {
        repository.delete(integer);
    }



}
