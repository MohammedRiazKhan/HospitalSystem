package me.mohammedriazkhan.factory.patient;

import me.mohammedriazkhan.domain.patient.Meal;
import me.mohammedriazkhan.helper.IDGenerator;


public class MealFactory {

    public static Meal getMeal(String fName, String lName, String specialisation) {
        return (Meal) new Meal.MealBuilder()
                .mealId(IDGenerator.generateId())
                .breakfast(fName)
                .lunch(lName)
                .supper(specialisation)
                .build();
    }



}
