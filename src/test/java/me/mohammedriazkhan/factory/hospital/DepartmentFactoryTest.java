package me.mohammedriazkhan.factory.hospital;

import me.mohammedriazkhan.domain.hospital.Department;
import me.mohammedriazkhan.domain.hospital.Room;
import me.mohammedriazkhan.domain.hospital.Ward;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class DepartmentFactoryTest {

    @Test
    public void getDepartment() {

        Department department = DepartmentFactory.getDepartment("a", "fa");
        System.out.println(department);

        Assert.assertNotNull(department.getDepartmentId());

    }
}