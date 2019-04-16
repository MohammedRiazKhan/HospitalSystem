package factories.employee;

import domain.employee.Cleaner;

public class CleanerFactory {

    public static Cleaner getCleaner(int employeeId, String firstName, String lastName, String identityNumber, String jobTitle, String dateOfEmployment, int[] rooms) {
        return (Cleaner) new Cleaner.CleanerBuilder()
                .rooms(rooms)
                .build();
    }

}
