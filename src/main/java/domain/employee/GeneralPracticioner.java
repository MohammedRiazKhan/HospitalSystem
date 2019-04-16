package domain.employee;

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
    }


    public String getPractice() {
        return practice;
    }

    public void setPractice(String practice) {
        this.practice = practice;
    }
}
