package factories.employee;

import domain.employee.Porter;

public class PorterFactory {

    public static Porter getPorter(int employeeId, String firstName, String lastName, String identityNumber, String jobTitle, String dateOfEmployment, int[] accessKeys) {
        return (Porter) new Porter.PorterBuilder()
                .build();
    }

}
