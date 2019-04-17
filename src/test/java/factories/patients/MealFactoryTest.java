package factories.patients;

import domain.patients.Meal;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MealFactoryTest {

    @Test
    public void getMeal() {

        Meal me = MealFactory.getMeal(1, "Pap", "Pap", "Pap");

        Assert.assertNotEquals(me.getBreakfast(), "notPap");

    }
}