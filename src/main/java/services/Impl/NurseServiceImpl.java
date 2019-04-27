package services.Impl;

import domain.employee.Nurse;
import repositories.Impl.NurseRepositoryImpl;
import repositories.employees.NurseRepository;
import services.employees.NurseService;

import java.util.Set;

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
