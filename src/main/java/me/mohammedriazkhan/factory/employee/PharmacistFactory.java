package me.mohammedriazkhan.factory.employee;

import me.mohammedriazkhan.domain.employee.Pharmacist;
import me.mohammedriazkhan.helper.IDGenerator;

public class PharmacistFactory {

    public static Pharmacist getPharmacist(String firstName, String lastName, String identityNumber, String jobTitle, String dateOfEmployment, int[] medic) {
        return (Pharmacist) new Pharmacist.PharmacistBuilder()
                .employeeId(IDGenerator.generateId())
                .firstName(firstName)
                .lastName(lastName)
                .identityNumber(identityNumber)
                .jobTitle(jobTitle)
                .dateOfEmployment(dateOfEmployment)
                .build();
    }

}
