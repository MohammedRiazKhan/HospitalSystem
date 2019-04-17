package factories.employee;

import domain.employee.Administration;
import org.junit.Assert;
import org.junit.Test;
import utility.IDGenerator;

import static org.junit.Assert.*;

public class AdministrationFactoryTest {

    @Test
    public void getAdministration1() {

        Administration admin = AdministrationFactory.getAdministration();

        Assert.assertNotNull(admin);

    }
}