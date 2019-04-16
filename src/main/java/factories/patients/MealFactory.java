package factories.patients;

import domain.patients.Meal;
import utility.IDGenerator;

public class MealFactory {

    public static Meal getMeal(int empId, String fName, String lName, String specialisation) {
        return (Meal) new Meal.MealBuilder()
                .mealId(IDGenerator.genId())
                .build();
    }

}
