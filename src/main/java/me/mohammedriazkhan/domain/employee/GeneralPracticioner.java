package me.mohammedriazkhan.domain.employee;

public class GeneralPracticioner extends Doctor {


    private String practice;

    public GeneralPracticioner(){

    }

    private GeneralPracticioner(GeneralPracticionerBuilder builder){

      super(builder);
      this.practice = builder.practice;

    }

    public static class GeneralPracticionerBuilder extends Doctor.DoctorBuilder{

        private String practice;

        public GeneralPracticionerBuilder(){
            super();
        }

        public GeneralPracticionerBuilder practice(String practice){
            this.practice = practice;
            return this;
        }

        @Override
        public Employee build() {
            return new GeneralPracticioner(this);
        }

        @Override
        public String toString() {
            return "GeneralPracticionerBuilder{" +
                    "practice='" + practice + '\'' +
                    "} " + super.toString();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            if (!super.equals(o)) return false;

            GeneralPracticionerBuilder that = (GeneralPracticionerBuilder) o;

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
