package me.mohammedriazkhan.domain.patient;

import java.util.Objects;

public class Meal {

    private String mealId;
    private String breakfast;
    private String lunch;
    private String supper;
    private Patient patient;

    public Meal(){}

    private Meal(MealBuilder builder){

        this.mealId = builder.mealId;
        this.breakfast = builder.breakfast;
        this.lunch = builder.lunch;
        this.supper = builder.supper;
        this.patient = builder.patient;

    }

    public String getMealId() {
        return mealId;
    }

    public void setMealId(String mealId) {
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

        private String mealId;
        private String breakfast;
        private String lunch;
        private String supper;
        private Patient patient;

        public MealBuilder mealId(String mealId){
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

        public MealBuilder copy(Meal meal){

            this.mealId(meal.getMealId());
            this.breakfast(meal.getBreakfast());
            this.lunch(meal.getLunch());
            this.supper(meal.getSupper());
            return this;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            MealBuilder that = (MealBuilder) o;
            return Objects.equals(mealId, that.mealId) &&
                    Objects.equals(breakfast, that.breakfast) &&
                    Objects.equals(lunch, that.lunch) &&
                    Objects.equals(supper, that.supper) &&
                    Objects.equals(patient, that.patient);
        }

        @Override
        public int hashCode() {
            return Objects.hash(mealId, breakfast, lunch, supper, patient);
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
