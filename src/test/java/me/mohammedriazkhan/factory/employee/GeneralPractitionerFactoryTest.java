package me.mohammedriazkhan.factory.employee;

import me.mohammedriazkhan.domain.employee.GeneralPractitioner;
import org.junit.Assert;
import org.junit.Test;

public class GeneralPractitionerFactoryTest {

    @Test
    public void getGeneralPractitioner() {

        GeneralPractitioner generalPractitioner = GeneralPractitionerFactory.getGeneralPractitioner(null, null, null, null, null, null);
        Assert.assertNotNull(generalPractitioner);
    }
}