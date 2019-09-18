package me.mohammedriazkhan.factory.hospital;

import me.mohammedriazkhan.domain.hospital.Department;
import me.mohammedriazkhan.domain.hospital.Hospital;
import me.mohammedriazkhan.helper.IDGenerator;


import java.util.List;

public class HospitalFactory {

    public static Hospital getHospital (String hospitalName, List<Department> departments) {
        return new Hospital.HospitalBuilder()
                .hospitalId(IDGenerator.generateId())
                .departments(departments)
                .hospitalName(hospitalName)
                .build();
    }


}
