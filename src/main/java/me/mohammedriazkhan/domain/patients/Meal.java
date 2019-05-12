package me.mohammedriazkhan.domain.patients;

public class Meal {

    private int mealId;
    private String breakfast;
    private String lunch;
    private String supper;
    private Patient patient;


    public Meal(){

    }


    private Meal(MealBuilder builder){

        this.mealId = builder.mealId;
        this.breakfast = builder.breakfast;
        this.lunch = builder.lunch;
        this.supper = builder.supper;
        this.patient = builder.patient;

    }

    public int getMealId() {
        return mealId;
    }

    public void setMealId(int mealId) {
        this.mealId = mealId;
    }

    public String getBreakfast() {
        return breakfast;
    }

    public void setBreakfast(String breakfast) {
        this.breakfast = breakfast;
    }

    public String getLunch() {
        return lunch;
    }

    public void setLunch(String lunch) {
        this.lunch = lunch;
    }

    public String getSupper() {
        return supper;
    }

    public void setSupper(String supper) {
        this.supper = supper;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public static class MealBuilder{
        private int mealId;
        private String breakfast;
        private String lunch;
        private String supper;
        private Patient patient;

        public MealBuilder mealId(int mealId){
            this.mealId = mealId;
            return this;
        }

        public MealBuilder breakfast(String breakfast){
            this.breakfast = breakfast;
            return this;
        }

        public MealBuilder lunch(String lunch){
            this.lunch = lunch;
            return this;
        }

        public MealBuilder supper(String supper){
            this.supper = supper;
            return this;
        }

        public MealBuilder patient(Patient patient){
            this.patient = patient;
            return this;
        }


        public Meal build(){
            return new Meal(this);
        }

        @Override
        public String toString() {
            return "MealBuilder{" +
                    "mealId=" + mealId +
                    ", breakfast='" + breakfast + '\'' +
                    ", lunch='" + lunch + '\'' +
                    ", supper='" + supper + '\'' +
                    ", patient=" + patient +
                    '}';
        }
    }

}
