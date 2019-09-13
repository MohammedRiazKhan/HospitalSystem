package me.mohammedriazkhan.repository.hospital.impl;

import me.mohammedriazkhan.domain.hospital.Department;
import me.mohammedriazkhan.repository.hospital.DepartmentRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Repository("DepartmentInMemory")
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

    @Override
    public Department create(Department department) {

       departments.add(department);
       return department;
    }

    @Override
    public Department read(String id) {

       return departments.stream().filter(department -> department.getDepartmentId().equals(id)).findAny().orElse(null);

    }

    @Override
    public Department update(Department department) {

        Department inDB = read(department.getDepartmentId());
        if(inDB != null){
            departments.remove(inDB);
            departments.add(department);
            return department;
        }
        return null;
    }

    @Override
    public void delete(String id) {

        Department inDB = read(id);
       departments.remove(inDB);

    }

    @Override
    public Set<Department> getAll() {
        return departments;
    }


}
