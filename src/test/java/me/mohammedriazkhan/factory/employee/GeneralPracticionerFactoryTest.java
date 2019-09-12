package me.mohammedriazkhan.factory.employee;

import me.mohammedriazkhan.domain.employee.GeneralPractitioner;
import org.junit.Assert;
import org.junit.Test;

public class GeneralPracticionerFactoryTest {

    @Test
    public void getGeneralPracticioner() {

        GeneralPractitioner generalPracticioner = GeneralPractitionerFactory.getGeneralPractitioner(1, null, null, null, null, null, null);
        Assert.assertNotNull(generalPracticioner);
    }
}