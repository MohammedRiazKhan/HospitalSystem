package me.mohammedriazkhan.factory.patient;

import me.mohammedriazkhan.domain.patient.Meal;
import org.junit.Assert;
import org.junit.Test;

public class MealFactoryTest {

    @Test
    public void getMeal() {

        Meal me = MealFactory.getMeal("Pap", "Pap", "Pap");
        System.out.println(me);
        Assert.assertNotEquals(me.getBreakfast(), "notPap");

    }
}