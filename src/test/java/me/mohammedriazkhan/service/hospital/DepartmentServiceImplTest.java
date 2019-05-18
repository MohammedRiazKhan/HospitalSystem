package me.mohammedriazkhan.service.hospital;

import me.mohammedriazkhan.domain.hospital.Department;
import me.mohammedriazkhan.factory.hospital.DepartmentFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import me.mohammedriazkhan.service.hospital.impl.DepartmentServiceImpl;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static junit.framework.TestCase.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DepartmentServiceImplTest {

    @Autowired
    DepartmentServiceImpl departmentService;


    @Test
    public void create() {

        Department department = DepartmentFactory.getDepartment(1, 1, null, null);
        departmentService.create(department);

        assertNotNull(departmentService.getAll());

    }

    @Test
    public void read() {

        Department department = DepartmentFactory.getDepartment(1, 1, null, null);
        departmentService.create(department);

        assertNotNull(departmentService.getAll());

        Department fromSet = departmentService.read(department.getDepartmentId());

        assertEquals(department, fromSet);


    }

    @Test
    public void update() {

        Department department = DepartmentFactory.getDepartment(1, 1, null, null);
        departmentService.create(department);

        assertNotNull(departmentService.getAll());

        Department departmentUpdate = DepartmentFactory.getDepartment(1, 2, null, null);
        departmentUpdate.setDepartmentId(department.getDepartmentId());
        departmentService.update(departmentUpdate);

        Department updated = departmentService.read(departmentUpdate.getDepartmentId());

        assertEquals(departmentUpdate, updated);

    }

    @Test
    public void delete() {

        Department department = DepartmentFactory.getDepartment(1, 1, null, null);
        departmentService.create(department);

        assertNotNull(departmentService.getAll());

        departmentService.delete(department.getDepartmentId());

        Department dep = departmentService.read(department.getDepartmentId());

        assertNull(dep);


    }
}