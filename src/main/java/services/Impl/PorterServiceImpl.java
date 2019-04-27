package services.Impl;

import domain.employee.Porter;
import repositories.Impl.PorterRepositoryImpl;
import repositories.employees.PorterRepository;
import services.employees.PorterService;

import java.util.Set;

public class PorterServiceImpl implements PorterService {

    private PorterServiceImpl service = null;
    private PorterRepository repository;

    public PorterServiceImpl() {
        repository = PorterRepositoryImpl.getRepository();
    }

    public PorterServiceImpl getService(){

        if(service == null){
            return new PorterServiceImpl();
        }
        return service;
    }

    @Override
    public Set<Porter> getAll() {
        return repository.getAll();
    }

    @Override
    public Porter create(Porter porter) {
        return repository.create(porter);
    }

    @Override
    public Porter read(Integer integer) {
        return repository.read(integer);
    }

    @Override
    public Porter update(Porter porter) {
        return repository.update(porter);
    }

    @Override
    public void delete(Integer integer) {

        repository.delete(integer);

    }
}
