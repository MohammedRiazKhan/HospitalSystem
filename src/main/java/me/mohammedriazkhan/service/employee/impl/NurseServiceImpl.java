package me.mohammedriazkhan.service.employee.impl;

import me.mohammedriazkhan.domain.employee.Nurse;
import me.mohammedriazkhan.repository.employee.impl.NurseRepositoryImpl;
import me.mohammedriazkhan.repository.employee.NurseRepository;
import me.mohammedriazkhan.service.employee.NurseService;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class NurseServiceImpl implements NurseService {

    private NurseServiceImpl service = null;
    private NurseRepository repository;

    public NurseServiceImpl() {
        repository = NurseRepositoryImpl.getRepository();
    }

    public NurseServiceImpl getService(){

        if(service == null){
            return new NurseServiceImpl();
        }
        return service;
    }

    @Override
    public Set<Nurse> getAll() {
        return repository.getAll();
    }

    @Override
    public Nurse create(Nurse nurse) {
        return repository.create(nurse);
    }

    @Override
    public Nurse read(Integer integer) {
        return repository.read(integer);
    }

    @Override
    public Nurse update(Nurse nurse) {
        return repository.update(nurse);
    }

    @Override
    public void delete(Integer integer) {

        repository.delete(integer);
    }
}
