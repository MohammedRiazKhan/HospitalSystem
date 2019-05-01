package me.mohammedriaz.factories.hospital;

import me.mohammedriaz.domain.hospital.Department;
import me.mohammedriaz.domain.hospital.Room;
import me.mohammedriaz.domain.hospital.Ward;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class DepartmentFactoryTest {

    @Test
    public void getDepartment() {


        List<Ward> ward = new ArrayList<>();
        List<Room> rooms = new ArrayList<>();

        Department department = DepartmentFactory.getDepartment(
                1,
                1,
                ward,
                rooms
                );

        Assert.assertNotNull(department.getDepartmentId());

    }
}