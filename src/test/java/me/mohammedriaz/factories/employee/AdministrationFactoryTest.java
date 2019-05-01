package me.mohammedriaz.factories.employee;

import me.mohammedriaz.domain.employee.Administration;
import org.junit.Assert;
import org.junit.Test;

public class AdministrationFactoryTest {

    @Test
    public void getAdministration1() {

        Administration admin = AdministrationFactory.getAdministration();

        Assert.assertNotNull(admin);

    }
}