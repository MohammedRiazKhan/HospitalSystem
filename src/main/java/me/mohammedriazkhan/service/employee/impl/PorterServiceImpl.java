package me.mohammedriazkhan.service.employee.impl;

import me.mohammedriazkhan.domain.employee.Porter;
import me.mohammedriazkhan.repository.employee.hibernate.PorterRepositoryHibernate;
import me.mohammedriazkhan.repository.employee.impl.PorterRepositoryImpl;
import me.mohammedriazkhan.repository.employee.PorterRepository;
import me.mohammedriazkhan.service.employee.PorterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Service
public class PorterServiceImpl implements PorterService {

    private PorterServiceImpl service = null;
    @Autowired
    private PorterRepositoryHibernate repository;

    public PorterServiceImpl() {
    }

    public PorterServiceImpl getService(){

        if(service == null){
            return new PorterServiceImpl();
        }
        return service;
    }

    @Override
    public Set<Porter> getAll() {
        List<Porter> list = (List<Porter>) repository.findAll();

        return new HashSet<>(list);
    }

    @Override
    public Porter create(Porter porter) {
        return repository.save(porter);
    }

    @Override
    public Porter read(String integer) {
        return repository.findById(integer).orElse(null);
    }

    @Override
    public Porter update(Porter porter) {
        return repository.save(porter);
    }

    @Override
    public void delete(String integer) {

        repository.deleteById(integer);

    }
}
