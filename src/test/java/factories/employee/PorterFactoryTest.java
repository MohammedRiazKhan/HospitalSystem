package factories.employee;

import domain.employee.Porter;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class PorterFactoryTest {

    @Test
    public void getPorter() {

        Porter porter = PorterFactory.getPorter(1, "clay", "pet", "123");

        Assert.assertNotNull(porter.getEmployeeId());


    }
}