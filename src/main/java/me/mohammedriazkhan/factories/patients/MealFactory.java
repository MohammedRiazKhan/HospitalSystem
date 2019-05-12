package me.mohammedriazkhan.factories.patients;

import me.mohammedriazkhan.domain.patients.Meal;
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
