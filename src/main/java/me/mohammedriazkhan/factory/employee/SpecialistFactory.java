package me.mohammedriazkhan.factory.employee;

import me.mohammedriazkhan.domain.employee.Specialist;
import me.mohammedriazkhan.helper.IDGenerator;

public class SpecialistFactory {

    public static Specialist getSpecialist(String firstName, String lastName, String identityNumber, String jobTitle, String dateOfEmployment, String spec) {
        return (Specialist) new Specialist.SpecialistBuilder()
                .employeeId(IDGenerator.generateId())
                .firstName(firstName)
                .lastName(lastName)
                .identityNumber(identityNumber)
                .jobTitle(jobTitle)
                .dateOfEmployment(dateOfEmployment)
                .build();
    }

}
