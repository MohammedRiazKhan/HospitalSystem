package me.mohammedriazkhan.factory.hospital;

import me.mohammedriazkhan.domain.hospital.Department;
import me.mohammedriazkhan.domain.hospital.Hospital;


import java.util.List;

public class HospitalFactory {

    public static Hospital getHospital(List<Department> departments, int hospitalId, String hospitalName) {
        return new Hospital.HospitalBuilder()
                .departments(departments)
                .hospitalId(hospitalId)
                .hospitalName(hospitalName)
                .build();
    }


}
