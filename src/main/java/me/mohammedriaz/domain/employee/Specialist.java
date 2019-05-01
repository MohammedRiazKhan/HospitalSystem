package me.mohammedriaz.domain.employee;

public class Specialist extends Doctor{

    private String school;

    public Specialist(){

    }

    private Specialist(SpecialistBuilder builder){
        super(builder);
        this.school = builder.school;
    }

    public static class SpecialistBuilder extends Doctor.DoctorBuilder{

        private String school;

        public SpecialistBuilder(){
            super();
        }

        public SpecialistBuilder school(String school){
            this.school = school;
            return this;
        }

        @Override
        public Employee build(){

            return new Specialist(this);

        }

        @Override
        public String toString() {
            return "SpecialistBuilder{" +
                    "school='" + school + '\'' +
                    "} " + super.toString();
        }
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }
}
