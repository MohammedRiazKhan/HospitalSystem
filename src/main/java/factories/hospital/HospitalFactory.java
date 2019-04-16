package factories.hospital;

import domain.hospital.Department;
import domain.hospital.Hospital;

import java.util.List;

public class HospitalFactory {

    public static Hospital getHospital(List<Department> departments, int hospitalId, String hospitalName) {
        return (Hospital) new Hospital.HospitalBuilder()
                .build();
    }
}
