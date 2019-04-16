package domain.employee;

public abstract class Employee {

    private int employeeId;
    private String firstName;
    private String lastName;
    private String identityNumber;
    private String jobTitle;
    private String dateOfEmployment;

    public Employee(){

    }

    protected Employee(Builder builder){

        this.employeeId = builder.employeeId;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.identityNumber = builder.identityNumber;
        this.jobTitle = builder.jobTitle;
        this.dateOfEmployment = builder.dateOfEmployment;

    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getIdentityNumber() {
        return identityNumber;
    }

    public void setIdentityNumber(String identityNumber) {
        this.identityNumber = identityNumber;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getDateOfEmployment() {
        return dateOfEmployment;
    }

    public void setDateOfEmployment(String dateOfEmployment) {
        this.dateOfEmployment = dateOfEmployment;
    }

    public static abstract class Builder{

        private int employeeId;
        private String firstName;
        private String lastName;
        private String identityNumber;
        private String jobTitle;
        private String dateOfEmployment;

        public Builder employeeId(int employeeId){
            this.employeeId = employeeId;
            return this;
        }

        public Builder firstName(String firstName){
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName){
            this.lastName = lastName;
            return this;
        }

        public Builder identityNumber(String identityNumber){
            this.identityNumber = identityNumber;
            return this;
        }

        public Builder jobTitle(String jobTitle){
            this.jobTitle = jobTitle;
            return this;
        }

        public Builder dateOfEmployment(String dateOfEmployment){
            this.dateOfEmployment = dateOfEmployment;
            return this;
        }

        public abstract Employee build();

        @Override
        public String toString() {
            return "Builder{" +
                    "employeeId=" + employeeId +
                    ", firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    ", identityNumber='" + identityNumber + '\'' +
                    ", jobTitle='" + jobTitle + '\'' +
                    ", dateOfEmployment='" + dateOfEmployment + '\'' +
                    '}';
        }
    }


}
