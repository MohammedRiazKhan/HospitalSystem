package me.mohammedriazkhan.factory.employee;

import me.mohammedriazkhan.domain.employee.Pharmacist;

public class PharmacistFactory {

    public static Pharmacist getPharmacist(int employeeId, String firstName, String lastName, String identityNumber, String jobTitle, String dateOfEmployment, int[] medic) {
        return (Pharmacist) new Pharmacist.PharmacistBuilder()
                .firstName(firstName)
                .lastName(lastName)
                .identityNumber(identityNumber)
                .jobTitle(jobTitle)
                .dateOfEmployment(dateOfEmployment)
                .build();
    }

}
