package me.mohammedriazkhan.factory.employee;

import me.mohammedriazkhan.domain.employee.Nurse;

public class NurseFactory {

    public static Nurse getNurse(int employeeId, String firstName, String lastName, String identityNumber, String jobTitle, String dateOfEmployment, String type) {
        return (Nurse) new Nurse.NurseBuilder()
                .firstName(firstName)
                .lastName(lastName)
                .identityNumber(identityNumber)
                .jobTitle(jobTitle)
                .dateOfEmployment(dateOfEmployment)
                .build();
    }

}
