package me.mohammedriazkhan.domain.patients;

import java.util.List;

public class InPatient extends Patient{

    private List<String> daysStayed;
    private List<Meal> meal;

    public InPatient(){

    }


    private InPatient(InPatientBuilder builder){
        super(builder);
        this.daysStayed = builder.daysStayed;
        this.meal = builder.meal;

    }

    public List<String> getDaysStayed() {
        return daysStayed;
    }

    public void setDaysStayed(List<String> daysStayed) {
        this.daysStayed = daysStayed;
    }

    public List<Meal> getMeal() {
        return meal;
    }

    public void setMeal(List<Meal> meal) {
        this.meal = meal;
    }

    public static class InPatientBuilder extends Patient.Builder{

        private List<String> daysStayed;
        private List<Meal> meal;

        public InPatientBuilder(){
            super();
        }

        public InPatientBuilder daysStayed(List<String> daysStayed){
            this.daysStayed = daysStayed;
            return this;
        }

        public InPatientBuilder meal(List<Meal> meal){
            this.meal = meal;
            return this;
        }

        @Override
        public Patient build() {
            return new InPatient(this);
        }

        @Override
        public String toString() {
            return "InPatientBuilder{" +
                    "daysStayed=" + daysStayed +
                    ", meal=" + meal +
                    "} " + super.toString();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            InPatientBuilder that = (InPatientBuilder) o;

            if (daysStayed != null ? !daysStayed.equals(that.daysStayed) : that.daysStayed != null) return false;
            return meal != null ? meal.equals(that.meal) : that.meal == null;

        }

        @Override
        public int hashCode() {
            int result = daysStayed != null ? daysStayed.hashCode() : 0;
            result = 31 * result + (meal != null ? meal.hashCode() : 0);
            return result;
        }
    }




}
