package factories.hospital;

import domain.hospital.Department;
import domain.hospital.Hospital;
import utility.IDGenerator;

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
