package me.mohammedriaz.repositories.Impl;

import me.mohammedriaz.domain.hospital.Department;
import me.mohammedriaz.repositories.hospital.DepartmentRepository;

import java.util.HashSet;
import java.util.Set;

public class DepartmentRepositoryImpl implements DepartmentRepository {


    private static DepartmentRepositoryImpl repository = null;
    private Set<Department> departments;

    public DepartmentRepositoryImpl(){
        departments = new HashSet<>();
    }

    public static DepartmentRepositoryImpl getRepository() {
        if(repository == null){

            return new DepartmentRepositoryImpl();

        }
        return repository;
    }

    public Department find(int id) {
        return departments.stream().filter(department -> department.getDepartmentId() == id).findAny().orElse(null);
    }

    @Override
    public Department create(Department department) {

        departments.add(department);

        return department;
    }

    @Override
    public Department read(Integer id) {

        Department department = find(id);
        if(department == null){
            return null;
        }
        else {
            return department;
        }

    }

    @Override
    public Department update(Department department) {

        Department department1 = find(department.getDepartmentId());

        if(departments.contains(department1)){
            departments.remove(department1);
            departments.add(department);
        }

        return department1;
    }

    @Override
    public void delete(Integer id) {
        Department department = find(id);
        departments.remove(department);

    }

    @Override
    public Set<Department> getAll() {
        return departments;
    }


}
