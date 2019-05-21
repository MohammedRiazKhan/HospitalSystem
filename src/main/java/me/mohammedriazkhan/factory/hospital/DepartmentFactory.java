package me.mohammedriazkhan.factory.hospital;

import me.mohammedriazkhan.domain.hospital.Department;
import me.mohammedriazkhan.domain.hospital.Room;
import me.mohammedriazkhan.domain.hospital.Ward;


import java.util.List;

public class DepartmentFactory {

    public static Department getDepartment(int departmentId, int hospitalId, List<Ward> wards, List<Room> rooms) {
        return new Department.DepartmentBuilder()
                .departmentId(departmentId)
                .hospitalId(hospitalId)
                .wards(wards)
                .rooms(rooms)
                .build();
    }


}
