package me.mohammedriazkhan.repository.hospital;

import me.mohammedriazkhan.domain.hospital.Department;
import me.mohammedriazkhan.factory.hospital.DepartmentFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import me.mohammedriazkhan.repository.hospital.impl.DepartmentRepositoryImpl;

public class DepartmentRepositoryTest {

    DepartmentRepositoryImpl departmentRepository;

    @Before
    public void setUp() throws Exception {

        departmentRepository = DepartmentRepositoryImpl.getRepository();

    }

    @Test
    public void create() {

        Department department = DepartmentFactory.getDepartment(1, 1, null, null);
        departmentRepository.create(department);

        Assert.assertNotNull(departmentRepository.getAll());

    }

    @Test
    public void read() {

        Department department = DepartmentFactory.getDepartment(1, 1, null, null);
        departmentRepository.create(department);

        Assert.assertNotNull(departmentRepository.getAll());

        Department fromSet = departmentRepository.read(department.getDepartmentId());

        Assert.assertEquals(department, fromSet);


    }

    @Test
    public void update() {

        Department department = DepartmentFactory.getDepartment(1, 1, null, null);
        departmentRepository.create(department);

        Assert.assertNotNull(departmentRepository.getAll());

        Department departmentUpdate = DepartmentFactory.getDepartment(1, 2, null, null);
        departmentUpdate.setDepartmentId(department.getDepartmentId());
        departmentRepository.update(departmentUpdate);

        Department updated = departmentRepository.read(departmentUpdate.getDepartmentId());

        Assert.assertEquals(departmentUpdate, updated);

    }

    @Test
    public void delete() {

        Department department = DepartmentFactory.getDepartment(1, 1, null, null);
        departmentRepository.create(department);

        Assert.assertNotNull(departmentRepository.getAll());

        departmentRepository.delete(department.getDepartmentId());

        Department dep = departmentRepository.read(department.getDepartmentId());

        Assert.assertNull(dep);


    }
}