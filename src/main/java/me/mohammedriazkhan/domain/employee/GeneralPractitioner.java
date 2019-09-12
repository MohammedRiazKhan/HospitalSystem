package me.mohammedriazkhan.domain.employee;

public class GeneralPractitioner extends Doctor {

    private String practice;

    public GeneralPractitioner(){

    }

    private GeneralPractitioner(GeneralPractitionerBuilder builder){

      super(builder);
      this.practice = builder.practice;

    }

    public static class GeneralPractitionerBuilder extends Doctor.DoctorBuilder{

        private String practice;

        public GeneralPractitionerBuilder(){
            super();
        }

        public GeneralPractitionerBuilder practice(String practice){
            this.practice = practice;
            return this;
        }

        @Override
        public Employee build() {
            return new GeneralPractitioner(this);
        }

        @Override
        public String toString() {
            return "GeneralPractitionerBuilder{" +
                    "practice='" + practice + '\'' +
                    "} " + super.toString();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            if (!super.equals(o)) return false;

            GeneralPractitionerBuilder that = (GeneralPractitionerBuilder) o;

            return practice != null ? practice.equals(that.practice) : that.practice == null;

        }

        @Override
        public int hashCode() {
            int result = super.hashCode();
            result = 31 * result + (practice != null ? practice.hashCode() : 0);
            return result;
        }
    }


    public String getPractice() {
        return practice;
    }

    public void setPractice(String practice) {
        this.practice = practice;
    }
}
