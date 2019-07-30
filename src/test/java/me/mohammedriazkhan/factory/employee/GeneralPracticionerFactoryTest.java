package me.mohammedriazkhan.factory.employee;

import me.mohammedriazkhan.domain.employee.GeneralPracticioner;
import org.junit.Assert;
import org.junit.Test;

public class GeneralPracticionerFactoryTest {

    @Test
    public void getGeneralPracticioner() {

        GeneralPracticioner generalPracticioner = GeneralPracticionerFactory.getGeneralPracticioner(1, null, null, null, null, null, null);
        Assert.assertNotNull(generalPracticioner);
    }
}