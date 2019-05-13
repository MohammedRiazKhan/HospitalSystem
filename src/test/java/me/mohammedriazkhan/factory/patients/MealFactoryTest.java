package me.mohammedriazkhan.factory.patients;

import me.mohammedriazkhan.domain.patients.Meal;
import org.junit.Assert;
import org.junit.Test;

public class MealFactoryTest {

    @Test
    public void getMeal() {

        Meal me = MealFactory.getMeal(1, "Pap", "Pap", "Pap");

        Assert.assertNotEquals(me.getBreakfast(), "notPap");

    }
}