package me.mohammedriazkhan.factory.employee;

import me.mohammedriazkhan.domain.employee.GeneralPractitioner;
import me.mohammedriazkhan.helper.IDGenerator;


public class GeneralPractitionerFactory {

    public static GeneralPractitioner getGeneralPractitioner(String firstName, String lastName, String identityNumber, String jobTitle, String dateOfEmployment, String practice) {
        return (GeneralPractitioner) new GeneralPractitioner.GeneralPractitionerBuilder()
                .employeeId(IDGenerator.generateId())
                .firstName(firstName)
                .lastName(lastName)
                .jobTitle(jobTitle)
                .build();
    }



}
