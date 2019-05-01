package me.mohammedriaz.factories.hospital;

import me.mohammedriaz.domain.hospital.Department;
import me.mohammedriaz.domain.hospital.Room;
import me.mohammedriaz.domain.hospital.Ward;
import me.mohammedriaz.utility.IDGenerator;

import java.util.List;

public class DepartmentFactory {

    public static Department getDepartment(int departmentId, int hospitalId, List<Ward> wards, List<Room> rooms) {
        return (Department) new Department.DepartmentBuilder()
                .departmentId(IDGenerator.genId())
                .hospitalId(hospitalId)
                .wards(wards)
                .rooms(rooms)
                .build();
    }


}
