package me.mohammedriazkhan.factory.employee;

import me.mohammedriazkhan.domain.employee.Nurse;
import me.mohammedriazkhan.helper.IDGenerator;

public class NurseFactory {

    public static Nurse getNurse(String firstName, String lastName, String identityNumber, String jobTitle, String dateOfEmployment, String type) {
        return (Nurse) new Nurse.NurseBuilder()
                .employeeId(IDGenerator.generateId())
                .firstName(firstName)
                .lastName(lastName)
                .identityNumber(identityNumber)
                .jobTitle(jobTitle)
                .dateOfEmployment(dateOfEmployment)
                .build();
    }

}
