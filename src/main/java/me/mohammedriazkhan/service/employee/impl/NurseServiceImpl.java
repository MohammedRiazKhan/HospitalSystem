package me.mohammedriazkhan.service.employee.impl;

import me.mohammedriazkhan.domain.employee.Nurse;
import me.mohammedriazkhan.repository.employee.hibernate.NurseRepositoryHibernate;
import me.mohammedriazkhan.repository.employee.impl.NurseRepositoryImpl;
import me.mohammedriazkhan.repository.employee.NurseRepository;
import me.mohammedriazkhan.service.employee.NurseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Service("NurseServiceImpl")
public class NurseServiceImpl implements NurseService {

    private NurseServiceImpl service = null;
    @Autowired
    private NurseRepositoryHibernate repository;

    public NurseServiceImpl() {
    }

    public NurseServiceImpl getService(){

        if(service == null){
            return new NurseServiceImpl();
        }
        return service;
    }

    @Override
    public Set<Nurse> getAll() {
        List<Nurse> list = (List<Nurse>) repository.findAll();

        return new HashSet<>(list);
    }

    @Override
    public Nurse create(Nurse nurse) {
        return repository.save(nurse);
    }

    @Override
    public Nurse read(String integer) {
        return repository.findById(integer).orElse(null);
    }

    @Override
    public Nurse update(Nurse nurse) {
        return repository.save(nurse);
    }

    @Override
    public void delete(String integer) {

        repository.deleteById(integer);
    }
}
