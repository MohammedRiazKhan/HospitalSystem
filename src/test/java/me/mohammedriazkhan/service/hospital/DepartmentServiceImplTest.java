package me.mohammedriazkhan.service.hospital;

import me.mohammedriazkhan.domain.hospital.Department;
import me.mohammedriazkhan.factory.hospital.DepartmentFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import me.mohammedriazkhan.service.Impl.DepartmentServiceImpl;

public class DepartmentServiceImplTest {
    DepartmentServiceImpl departmentService;

    @Before
    public void setUp() throws Exception {

        departmentService = new DepartmentServiceImpl();

    }

    @Test
    public void create() {

        Department department = DepartmentFactory.getDepartment(1, 1, null, null);
        departmentService.create(department);

        Assert.assertNotNull(departmentService.getAll());

    }

    @Test
    public void read() {

        Department department = DepartmentFactory.getDepartment(1, 1, null, null);
        departmentService.create(department);

        Assert.assertNotNull(departmentService.getAll());

        Department fromSet = departmentService.read(department.getDepartmentId());

        Assert.assertEquals(department, fromSet);


    }

    @Test
    public void update() {

        Department department = DepartmentFactory.getDepartment(1, 1, null, null);
        departmentService.create(department);

        Assert.assertNotNull(departmentService.getAll());

        Department departmentUpdate = DepartmentFactory.getDepartment(1, 2, null, null);
        departmentUpdate.setDepartmentId(department.getDepartmentId());
        departmentService.update(departmentUpdate);

        Department updated = departmentService.read(departmentUpdate.getDepartmentId());

        Assert.assertEquals(departmentUpdate, updated);

    }

    @Test
    public void delete() {

        Department department = DepartmentFactory.getDepartment(1, 1, null, null);
        departmentService.create(department);

        Assert.assertNotNull(departmentService.getAll());

        departmentService.delete(department.getDepartmentId());

        Department dep = departmentService.read(department.getDepartmentId());

        Assert.assertNull(dep);


    }
}