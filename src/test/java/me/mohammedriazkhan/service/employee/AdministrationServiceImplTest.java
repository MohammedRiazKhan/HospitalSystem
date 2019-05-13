package me.mohammedriazkhan.service.employee;

import me.mohammedriazkhan.domain.employee.Administration;
import me.mohammedriazkhan.factory.employee.AdministrationFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import me.mohammedriazkhan.service.employee.impl.AdministrationServiceImpl;

public class AdministrationServiceImplTest {

    AdministrationServiceImpl administrationService;

    @Before
    public void setUp() throws Exception {

        administrationService = new AdministrationServiceImpl();

    }

    @Test
    public void create() {

        Administration admin = AdministrationFactory.getAdministration();
        administrationService.create(admin);

        Assert.assertNotNull(administrationService.getAll());

    }

    @Test
    public void read() {

        //Create a admin staff and add to set
        Administration admin = AdministrationFactory.getAdministration();
        administrationService.create(admin);

        //retrieve the adminStaff
        Administration adminInSet = administrationService.read(admin.getEmployeeId());

        Assert.assertEquals(admin, adminInSet);

    }

    @Test
    public void update() {

        //Create a admin staff and add to set
        Administration admin = AdministrationFactory.getAdministration();
        administrationService.create(admin);

        //updated version
        Administration adminUpdate = AdministrationFactory.getAdministration();
        adminUpdate.setEmployeeId(admin.getEmployeeId());
        administrationService.update(adminUpdate);

        //get the updated version
        Administration updatedVersion = administrationService.read(adminUpdate.getEmployeeId());

        Assert.assertEquals(adminUpdate, updatedVersion);

    }

    @Test
    public void delete() {

        //Create a admin staff and add to set
        Administration admin = AdministrationFactory.getAdministration();
        administrationService.create(admin);

        //checks that its not empty
        Assert.assertNotNull(administrationService.getAll());

        administrationService.delete(admin.getEmployeeId());

        //check if its deleted
        Administration updatedVersion = administrationService.read(admin.getEmployeeId());

        Assert.assertNull(updatedVersion);//will pass if its not there


    }
}