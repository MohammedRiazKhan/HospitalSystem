package factories.employee;

import domain.employee.GeneralPracticioner;
import utility.IDGenerator;

public class GeneralPracticionerFactory {

    public static GeneralPracticioner getGeneralPracticioner(int employeeId, String firstName, String lastName, String identityNumber, String jobTitle, String dateOfEmployment, String practice) {
        return (GeneralPracticioner) new GeneralPracticioner.GeneralPracticionerBuilder()
                .employeeId(IDGenerator.genId())
                .firstName(firstName)
                .lastName(lastName)
                .jobTitle(jobTitle)
                .build();
    }



}
