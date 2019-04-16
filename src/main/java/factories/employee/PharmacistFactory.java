package factories.employee;

import domain.employee.Pharmacist;

public class PharmacistFactory {

    public static Pharmacist getPharmacist(int employeeId, String firstName, String lastName, String identityNumber, String jobTitle, String dateOfEmployment, int[] medic) {
        return (Pharmacist) new Pharmacist.PharmacistBuilder()

                .build();
    }

}
