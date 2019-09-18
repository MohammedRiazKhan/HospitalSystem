package me.mohammedriazkhan.factory.employee;

import me.mohammedriazkhan.domain.employee.Administration;
import org.junit.Assert;
import org.junit.Test;

public class AdministrationFactoryTest {

    @Test
    public void getAdministration() {

        Administration admin = AdministrationFactory.getAdministration( "Riaz", "Khan", "1234567", "8 July 2019", "receptionist", "Super Access");
        System.out.println(admin);
        Assert.assertNotNull(admin);

    }
}