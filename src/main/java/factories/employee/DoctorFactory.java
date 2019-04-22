package factories.employee;

import domain.employee.Doctor;
import domain.employee.Employee;
import domain.patients.Patient;
import utility.IDGenerator;

import java.util.List;

public class DoctorFactory {

    public static Doctor getDoctor(String fName, String lName, String specialisation) {
        return (Doctor) new Doctor.DoctorBuilder()
                .employeeId(IDGenerator.genId())
                .firstName(fName)
                .lastName(lName)
                .build();
    }

}
