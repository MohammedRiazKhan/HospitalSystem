package me.mohammedriazkhan.factory.employee;

import me.mohammedriazkhan.domain.employee.Specialist;

public class SpecialistFactory {

    public static Specialist getSpecialist(int employeeId, String firstName, String lastName, String identityNumber, String jobTitle, String dateOfEmployment, String spec) {
        return (Specialist) new Specialist.SpecialistBuilder()
                .firstName(firstName)
                .lastName(lastName)
                .identityNumber(identityNumber)
                .jobTitle(jobTitle)
                .dateOfEmployment(dateOfEmployment)
                .build();
    }

}
