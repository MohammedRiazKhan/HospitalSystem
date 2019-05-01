package me.mohammedriaz.factories.employee;

import me.mohammedriaz.domain.employee.Doctor;
import me.mohammedriaz.utility.IDGenerator;

public class DoctorFactory {

    public static Doctor getDoctor(String fName, String lName, String specialisation) {
        return (Doctor) new Doctor.DoctorBuilder()
                .employeeId(IDGenerator.genId())
                .firstName(fName)
                .lastName(lName)
                .build();
    }

}
