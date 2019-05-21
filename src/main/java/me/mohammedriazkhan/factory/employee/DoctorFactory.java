package me.mohammedriazkhan.factory.employee;

import me.mohammedriazkhan.domain.employee.Doctor;


public class DoctorFactory {

    public static Doctor getDoctor(int id, String fName, String lName, String specialisation) {
        return (Doctor) new Doctor.DoctorBuilder()
                .specialisation(specialisation)
                .employeeId(id)
                .firstName(fName)
                .lastName(lName)
                .build();
    }

}
