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
    private Map<Integer, Department> departments;

    public DepartmentRepositoryImpl(){
        departments = new HashMap<>();
    }

    public static DepartmentRepositoryImpl getRepository() {
        if(repository == null){

            return new DepartmentRepositoryImpl();

        }
        return repository;
    }

    /*public Department find(int id) {
        return departments.stream().filter(department -> department.getDepartmentId() == id).findAny().orElse(null);
    }*/

    @Override
    public Department create(Department department) {

        departments.put(department.getDepartmentId(), department);

        return department;
    }

    @Override
    public Department read(Integer id) {

       return departments.get(id);

    }

    @Override
    public Department update(Department department) {

       departments.replace(department.getDepartmentId(), department);
       return departments.get(department.getDepartmentId());
    }

    @Override
    public void delete(Integer id) {
       departments.remove(id);

    }

    @Override
    public Set<Department> getAll() {
        return new HashSet<>(departments.values());
    }


}
