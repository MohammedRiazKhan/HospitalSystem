package me.mohammedriazkhan.factory.patient;

import me.mohammedriazkhan.domain.patient.Meal;


public class MealFactory {

    public static Meal getMeal(int empId, String fName, String lName, String specialisation) {
        return (Meal) new Meal.MealBuilder()
                .mealId(empId)
                .breakfast(fName)
                .lunch(lName)
                .supper(specialisation)
                .build();
    }



}
