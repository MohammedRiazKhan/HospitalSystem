package me.mohammedriazkhan.service.employee.impl;

import me.mohammedriazkhan.domain.employee.Porter;
import me.mohammedriazkhan.repository.employee.impl.PorterRepositoryImpl;
import me.mohammedriazkhan.repository.employee.PorterRepository;
import me.mohammedriazkhan.service.employee.PorterService;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
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
