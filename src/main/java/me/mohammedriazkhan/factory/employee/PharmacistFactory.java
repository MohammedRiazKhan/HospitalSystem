package me.mohammedriazkhan.factory.employee;

import me.mohammedriazkhan.domain.employee.Pharmacist;
import me.mohammedriazkhan.helper.IDGenerator;

public class PharmacistFactory {

    public static Pharmacist getPharmacist(String firstName, String lastName, String identificationNumber, String employmentDate, String jobTitle, String license) {
        return (Pharmacist) new Pharmacist.PharmacistBuilder()
                .licence(license)
                .employeeId(IDGenerator.generateId())
                .firstName(firstName)
                .lastName(lastName)
                .identityNumber(identificationNumber)
                .employmentDate(employmentDate)
                .jobTitle(jobTitle)
                .build();
    }

}
