package factories.hospital;

import domain.hospital.Department;
import domain.hospital.Room;
import domain.hospital.Ward;
import utility.IDGenerator;

import java.util.List;

public class DepartmentFactory {

    public static Department getDepartment(int departmentId, int hospitalId, List<Ward> wards, List<Room> rooms) {
        return (Department) new Department.DepartmentBuilder()
                .build();
    }

}
