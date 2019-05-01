package me.mohammedriaz.domain.patients;

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
    }




}
