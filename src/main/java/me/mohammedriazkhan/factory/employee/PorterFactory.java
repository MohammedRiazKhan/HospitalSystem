package me.mohammedriazkhan.factory.employee;

import me.mohammedriazkhan.domain.employee.Porter;
import me.mohammedriazkhan.helper.IDGenerator;


public class PorterFactory {

    public static Porter getPorter(String firstName, String lastName, String identificationNumber, String employmentDate, String jobTitle, String accessKeys) {
        return (Porter) new Porter.PorterBuilder()
                .accessKeys(accessKeys)
                .employeeId(IDGenerator.generateId())
                .firstName(firstName)
                .lastName(lastName)
                .identityNumber(identificationNumber)
                .employmentDate(employmentDate)
                .jobTitle(jobTitle)
                .build();
    }



}
