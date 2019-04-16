package factories.employee;

import domain.employee.Administration;
import domain.employee.Employee;
import utility.IDGenerator;

public class AdministrationFactory {

    public static Administration getAdministration(int employeeId, String firstName, String lastName, String identityNumber, String jobTitle, String dateOfEmployment, String accessLevel) {
        return (Administration) new Administration.AdminBuilder()
                .accessLevel(accessLevel)
                .build();
    }



}
