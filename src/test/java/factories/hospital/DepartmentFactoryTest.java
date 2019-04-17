package factories.hospital;

import domain.hospital.Department;
import domain.hospital.Room;
import domain.hospital.Ward;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

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