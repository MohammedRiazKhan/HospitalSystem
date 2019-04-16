package factories.employee;

import domain.employee.Doctor;
import domain.employee.Employee;
import domain.patients.Patient;

import java.util.List;

public class DoctorFactory {

    public static Doctor getDoctor(int empId, String fName, String lName, String specialisation, List<Patient> patientList) {
        return (Doctor) new Doctor.DoctorBuilder()
                .specialisation(specialisation)
                .firstName(fName)
                .lastName(lName)
                .employeeId(empId)
                .build();
    }

}
