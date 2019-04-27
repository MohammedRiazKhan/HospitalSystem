package services.Impl;

import domain.hospital.Ward;
import repositories.Impl.WardRepositoryImpl;
import repositories.hospital.WardRepository;
import services.hospital.WardService;

import java.util.Set;

public class WardServiceImpl implements WardService {

    private WardServiceImpl service = null;
    private WardRepository repository;

    public WardServiceImpl() {
        repository = WardRepositoryImpl.getWards();
    }

    public WardServiceImpl getService(){

        if(service == null){
            return new WardServiceImpl();
        }
        return service;
    }

    @Override
    public Set<Ward> getAll() {
        return repository.getAll();
    }

    @Override
    public Ward create(Ward ward) {
        return repository.create(ward);
    }

    @Override
    public Ward read(Integer integer) {
        return repository.read(integer);
    }

    @Override
    public Ward update(Ward ward) {
        return repository.update(ward);
    }

    @Override
    public void delete(Integer integer) {

        repository.delete(integer);
    }
}
