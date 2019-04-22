package repositories.hospital;


import domain.hospital.Department;
import repositories.Repository;

import java.util.HashSet;
import java.util.Set;

public class DepartmentRepository implements Repository<Department> {

    private static DepartmentRepository repository = null;
    private Set<Department> departments;

    public DepartmentRepository(){
        departments = new HashSet<>();
    }

    public static DepartmentRepository getRepository() {
        if(repository == null){

            return new DepartmentRepository();

        }
        return repository;
    }

    @Override
    public Department find(int id) {
        return departments.stream().filter(department -> department.getDepartmentId() == id).findAny().orElse(null);
    }

    @Override
    public void create(Department department) {

        departments.add(department);

    }

    @Override
    public Department read(int id) {
        return find(id);
    }

    @Override
    public void update(Department department) {

        Department department1 = find(department.getDepartmentId());

        if(departments.contains(department1)){
            departments.remove(department1);
            departments.add(department);
        }

    }

    @Override
    public void delete(Department department) {

        departments.remove(department);

    }

    @Override
    public Set<Department> getAll() {
        return departments;
    }



}
