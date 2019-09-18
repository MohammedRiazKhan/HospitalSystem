package me.mohammedriazkhan.factory.employee;

import me.mohammedriazkhan.domain.employee.Doctor;
import me.mohammedriazkhan.helper.IDGenerator;


public class DoctorFactory {

    public static Doctor getDoctor(String firstName, String lastName, String identificationNumber, String employmentDate, String jobTitle, String specialisation) {
        return (Doctor) new Doctor.DoctorBuilder()
                .specialisation(specialisation)
                .employeeId(IDGenerator.generateId())
                .firstName(firstName)
                .lastName(lastName)
                .identityNumber(identificationNumber)
                .employmentDate(employmentDate)
                .jobTitle(jobTitle)
                .build();
    }

}
