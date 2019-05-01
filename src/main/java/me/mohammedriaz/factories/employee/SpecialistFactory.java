package me.mohammedriaz.factories.employee;

import me.mohammedriaz.domain.employee.Specialist;

public class SpecialistFactory {

    public static Specialist getSpecialist(int employeeId, String firstName, String lastName, String identityNumber, String jobTitle, String dateOfEmployment, String spec) {
        return (Specialist) new Specialist.SpecialistBuilder()

                .build();
    }

}
