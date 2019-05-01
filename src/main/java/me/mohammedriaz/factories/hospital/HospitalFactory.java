package me.mohammedriaz.factories.hospital;

import me.mohammedriaz.domain.hospital.Department;
import me.mohammedriaz.domain.hospital.Hospital;
import me.mohammedriaz.utility.IDGenerator;

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
