package services.Impl;

import domain.hospital.Department;
import repositories.Impl.DepartmentRepositoryImpl;
import repositories.hospital.DepartmentRepository;
import services.hospital.DepartmentService;

import java.util.Set;

public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentServiceImpl service = null;
    private DepartmentRepository repository;

    public DepartmentServiceImpl() {
        repository = DepartmentRepositoryImpl.getRepository();
    }

    public DepartmentServiceImpl getService(){

        if(service == null){
            return new DepartmentServiceImpl();
        }
        return service;
    }


    @Override
    public Set<Department> getAll() {
        return repository.getAll();
    }

    @Override
    public Department create(Department department) {
        return repository.create(department);
    }

    @Override
    public Department read(Integer integer) {
        return repository.read(integer);
    }

    @Override
    public Department update(Department department) {
        return repository.update(department);
    }

    @Override
    public void delete(Integer integer) {
        repository.delete(integer);
    }



}