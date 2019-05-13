package me.mohammedriazkhan.domain.employee;

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

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            if (!super.equals(o)) return false;

            SpecialistBuilder that = (SpecialistBuilder) o;

            return school != null ? school.equals(that.school) : that.school == null;

        }

        @Override
        public int hashCode() {
            int result = super.hashCode();
            result = 31 * result + (school != null ? school.hashCode() : 0);
            return result;
        }
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }
}
