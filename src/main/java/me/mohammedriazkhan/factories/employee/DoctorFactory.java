package me.mohammedriazkhan.factories.employee;

import me.mohammedriazkhan.domain.employee.Doctor;
import me.mohammedriazkhan.utility.IDGenerator;

public class DoctorFactory {

    public static Doctor getDoctor(String fName, String lName, String specialisation) {
        return (Doctor) new Doctor.DoctorBuilder()
                .employeeId(IDGenerator.genId())
                .firstName(fName)
                .lastName(lName)
                .build();
    }

}
