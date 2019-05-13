package me.mohammedriazkhan.factory.hospital;

import me.mohammedriazkhan.domain.hospital.Department;
import me.mohammedriazkhan.domain.hospital.Room;
import me.mohammedriazkhan.domain.hospital.Ward;
import me.mohammedriazkhan.utility.IDGenerator;

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
