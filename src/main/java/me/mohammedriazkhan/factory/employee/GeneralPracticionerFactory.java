package me.mohammedriazkhan.factory.employee;

import me.mohammedriazkhan.domain.employee.GeneralPracticioner;


public class GeneralPracticionerFactory {

    public static GeneralPracticioner getGeneralPracticioner(int employeeId, String firstName, String lastName, String identityNumber, String jobTitle, String dateOfEmployment, String practice) {
        return (GeneralPracticioner) new GeneralPracticioner.GeneralPracticionerBuilder()
                .employeeId(employeeId)
                .firstName(firstName)
                .lastName(lastName)
                .jobTitle(jobTitle)
                .build();
    }



}
