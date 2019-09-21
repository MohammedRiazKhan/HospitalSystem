package me.mohammedriazkhan.domain.employee;

public abstract class Employee {

    private String employeeId;
    private String firstName;
    private String lastName;
    private String identityNumber;
    private String jobTitle;
    private String employmentDate;

    public Employee(){

    }

    protected Employee(Builder builder){

        this.employeeId = builder.employeeId;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.identityNumber = builder.identityNumber;
        this.jobTitle = builder.jobTitle;
        this.employmentDate = builder.employmentDate;

    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
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

    public String getEmploymentDate() {
        return employmentDate;
    }

    public void setEmploymentDate(String employmentDate) {
        this.employmentDate = employmentDate;
    }

    public static abstract class Builder{

        private String employeeId;
        private String firstName;
        private String lastName;
        private String identityNumber;
        private String jobTitle;
        private String employmentDate;

        public Builder employeeId(String employeeId){
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

        public Builder employmentDate(String employmentDate){
            this.employmentDate = employmentDate;
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
                    ", employmentDate='" + employmentDate + '\'' +
                    "" +
                    '}';
        }
    }


}
