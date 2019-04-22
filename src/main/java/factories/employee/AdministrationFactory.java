package factories.employee;

import domain.employee.Administration;
import domain.employee.Employee;
import utility.IDGenerator;

public class AdministrationFactory {

    public static Administration getAdministration() {
        return (Administration) new Administration.AdminBuilder()
                .accessLevel("1")
                .employeeId(IDGenerator.genId())
                .build();
    }




}
