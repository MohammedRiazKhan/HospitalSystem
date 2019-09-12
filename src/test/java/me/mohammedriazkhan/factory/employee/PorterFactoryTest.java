package me.mohammedriazkhan.factory.employee;

import me.mohammedriazkhan.domain.employee.Porter;
import org.junit.Assert;
import org.junit.Test;

public class PorterFactoryTest {

    @Test
    public void getPorter() {

        Porter porter = PorterFactory.getPorter("clay", "pet", "123");

        Assert.assertNotNull(porter.getEmployeeId());


    }
}