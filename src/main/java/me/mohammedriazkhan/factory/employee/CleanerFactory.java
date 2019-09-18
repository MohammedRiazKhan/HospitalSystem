package me.mohammedriazkhan.factory.employee;

import me.mohammedriazkhan.domain.employee.Cleaner;
import me.mohammedriazkhan.helper.IDGenerator;


public class CleanerFactory {

    public static Cleaner getCleaner(String firstName, String lastName, String identificationNumber, String employmentDate, String jobTitle, String duties) {
        return (Cleaner) new Cleaner.CleanerBuilder()
                .duties(duties)
                .employeeId(IDGenerator.generateId())
                .firstName(firstName)
                .lastName(lastName)
                .identityNumber(identificationNumber)
                .employmentDate(employmentDate)
                .jobTitle(jobTitle)
                .build();
    }



}
