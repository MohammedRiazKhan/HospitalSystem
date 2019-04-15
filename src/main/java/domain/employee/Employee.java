package domain.employee;

public abstract class Employee {

    private int employeeId;
    private String firstName;
    private String lastName;
    private String identityNumber;
    private String jobTitle;
    private String dateOfEmployment;


    public Employee(int employeeId, String firstName, String lastName, String identityNumber, String jobTitle, String dateOfEmployment) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.identityNumber = identityNumber;
        this.jobTitle = jobTitle;
        this.dateOfEmployment = dateOfEmployment;
    }
}
