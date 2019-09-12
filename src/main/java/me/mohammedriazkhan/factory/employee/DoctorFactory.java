package me.mohammedriazkhan.factory.employee;

import me.mohammedriazkhan.domain.employee.Doctor;
import me.mohammedriazkhan.helper.IDGenerator;


public class DoctorFactory {

    public static Doctor getDoctor(String fName, String lName, String specialisation) {
        return (Doctor) new Doctor.DoctorBuilder()
                .specialisation(specialisation)
                .employeeId(IDGenerator.generateId())
                .firstName(fName)
                .lastName(lName)
                .build();
    }

}
