package me.mohammedriazkhan.factory.hospital;

import me.mohammedriazkhan.domain.hospital.Department;
import me.mohammedriazkhan.domain.hospital.Hospital;
import me.mohammedriazkhan.utility.IDGenerator;

import java.util.List;

public class HospitalFactory {

    public static Hospital getHospital(List<Department> departments, int hospitalId, String hospitalName) {
        return (Hospital) new Hospital.HospitalBuilder()
                .departments(departments)
                .hospitalId(IDGenerator.genId())
                .hospitalName(hospitalName)
                .build();
    }


}
