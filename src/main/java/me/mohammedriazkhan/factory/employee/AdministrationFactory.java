package me.mohammedriazkhan.factory.employee;

import me.mohammedriazkhan.domain.employee.Administration;
import me.mohammedriazkhan.helper.IDGenerator;


public class AdministrationFactory {

    public static Administration getAdministration(String firstName, String lastName, String identificationNumber, String employmentDate, String jobTitle, String access) {
        return (Administration) new Administration.AdminBuilder()
                .accessLevel(access)
                .employeeId(IDGenerator.generateId())
                .firstName(firstName)
                .lastName(lastName)
                .identityNumber(identificationNumber)
                .employmentDate(employmentDate)
                .jobTitle(jobTitle)
                .build();
    }




}
