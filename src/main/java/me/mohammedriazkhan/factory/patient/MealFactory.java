package me.mohammedriazkhan.factory.patient;

import me.mohammedriazkhan.domain.patient.Meal;
import me.mohammedriazkhan.utility.IDGenerator;

public class MealFactory {

    public static Meal getMeal(int empId, String fName, String lName, String specialisation) {
        return (Meal) new Meal.MealBuilder()
                .mealId(IDGenerator.genId())
                .breakfast(fName)
                .lunch(lName)
                .supper(specialisation)
                .build();
    }



}
