package me.mohammedriazkhan.factory.employee;

import me.mohammedriazkhan.domain.employee.Porter;
import org.junit.Assert;
import org.junit.Test;

public class PorterFactoryTest {

    @Test
    public void getPorter() {

        Porter porter = PorterFactory.getPorter("Mohammed Riaz", "Khan", "1234564", "1 May 2501", "Renal Doctor", "SuperKey");
        System.out.println(porter);
        Assert.assertNotNull(porter.getEmployeeId());


    }
}