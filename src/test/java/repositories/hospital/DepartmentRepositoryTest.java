package repositories.hospital;

import domain.hospital.Department;
import factories.hospital.DepartmentFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import repositories.Impl.DepartmentRepositoryImpl;

import static org.junit.Assert.*;

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

        Department fromSet = departmentRepository.find(department.getDepartmentId());

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

        Department updated = departmentRepository.find(departmentUpdate.getDepartmentId());

        Assert.assertEquals(departmentUpdate, updated);

    }

    @Test
    public void delete() {

        Department department = DepartmentFactory.getDepartment(1, 1, null, null);
        departmentRepository.create(department);

        Assert.assertNotNull(departmentRepository.getAll());

        departmentRepository.delete(department.getDepartmentId());

        Department dep = departmentRepository.find(department.getDepartmentId());

        Assert.assertNull(dep);


    }
}